package com.github.enerccio.e8.e8_asm;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import com.github.enerccio.e8.e8_asm.AssembledUnit.AddressMode;

public class Linker {
	
	private static class BlockFit {
		private int start = -1;
		private int size;
		private List<AssembledUnit> units = new ArrayList<AssembledUnit>();
	}
	
	private List<AssembledUnit> linkedUnits;
	
	public Linker(List<AssembledUnit> assembleUnits) {
		linkedUnits = assembleUnits;
	}

	public void link(String outputFile) throws Exception {
		Map<String, AssembledUnit> units = flatten();
		
		List<Byte> ol = new ArrayList<Byte>(65536);
		for (int i=0; i<65536; i++)
			ol.add(null);
		
		List<BlockFit> blockFits = new ArrayList<BlockFit>();
		
		Set<AssembledUnit> alreadyReferenced = new HashSet<AssembledUnit>();
		// mandatory blocks
		for (AssembledUnit au : linkedUnits) {
			if (!au.isLibrary() && !alreadyReferenced.contains(au)) {
				BlockFit bf = new BlockFit();
				AssembledUnit a = au;
				while (a != null) {
					bf.units.add(a);
					alreadyReferenced.add(a);
					a = a.getNext();
				}
				bf.size = (int) bf.units.stream().map(i -> i.getOperations().size()).collect(Collectors.summarizingInt(i -> Integer.valueOf(i))).getSum();
				blockFits.add(bf);
			}
		}
		
		boolean needsResolving = true;
		while (needsResolving) {
			List<BlockFit> newFits = new ArrayList<BlockFit>();
			
			for (BlockFit bf : blockFits) {
				for (AssembledUnit au : bf.units) {
					for (String nr : au.getRequestedOutboundLinks()) {
						AssembledUnit auR = units.get(nr);
						if (auR == null) {
							throw new AssemblyException("No block found for name " + nr);
						}
						
						if (!alreadyReferenced.contains(auR)) {
							bf = new BlockFit();
							AssembledUnit a = auR;
							while (a != null) {
								bf.units.add(a);
								alreadyReferenced.add(a);
								a = a.getNext();
							}
							bf.size = (int) bf.units.stream().map(i -> i.getOperations().size()).collect(Collectors.summarizingInt(i -> Integer.valueOf(i))).getSum();
							newFits.add(bf);
						}
					}
				}
			}
			
			blockFits.addAll(newFits);
			needsResolving = !newFits.isEmpty();
		}
		
		// fixed placement
		for (BlockFit bf : blockFits) {
			if (bf.units.get(0).getMode() == AddressMode.STATIC) {
				bf.start = bf.units.get(0).getAddress();
			}
		}
		
		fitToRam(blockFits);
		
		Map<AssembledUnit, Integer> positions = new HashMap<AssembledUnit, Integer>();
		for (BlockFit bf : blockFits) {
			int pos = bf.start;
			for (AssembledUnit au : bf.units) {
				positions.put(au, pos);
				pos += au.getOperations().size();
			}
		}
		
		// map everything
		for (BlockFit bf : blockFits) {
			for (AssembledUnit au : bf.units) {
				for (MemoryResolver mr : au.getMrs()) {
					String module = mr.getModule();
					AssembledUnit rm = au;
					if (module != null) {
						rm = units.get(module);
					}
					
					if (mr.getSublabel() != null && mr.getModule() != null) {
						throw new AssemblyException("Non local reference exception");
					}
					
					mr.setAddress((short) (positions.get(rm) + rm.getLabels().get(mr.getLabel()) + 
							(mr.getSublabel() == null ? 0 : rm.getInternalLabels().get(mr.getSublabel()))));
				}
			}
		}
		
		// output operations
		
		for (BlockFit bf : blockFits) {
			int pos = bf.start;
			for (AssembledUnit au : bf.units) {
				for (Instruction o : au.getOperations()) {
					ol.set(pos, o.toByte());
					++pos;
				}
			}
		}
		
		File out = new File(outputFile);
		String textValue = StringUtils.join(ol.stream().map(this::toHexString).collect(Collectors.toList()), ", ");
		String[] values = textValue.split(Pattern.quote(" "));
		
		FileOutputStream fos = new FileOutputStream(out);
		List<String> elems = new ArrayList<String>(8);
		for (int i=0; i<65536; i++) {
			elems.add(values[i]);
			if (elems.size() == 8) {
				IOUtils.write((StringUtils.join(elems, " ") + "\n").getBytes(Charset.forName("utf-8")), fos);
				elems.clear();
			}
		}
		fos.close();
	}
	
	private String toHexString(Byte v) {
		if (v == null)
			return "X\"00\"";
		return String.format("X\"%02X\"", v);
	}
	
	private static class Fit {
		public int start;
		public int width;
		public boolean free;
		
		public Fit(int start, int width, boolean free) {
			this.start = start;
			this.width = width;
			this.free = free;
		}
	}

	private void fitToRam(List<BlockFit> blockFits) {
		List<BlockFit> sorted = new ArrayList<BlockFit>(blockFits);
		
		List<Fit> fitted = new ArrayList<Fit>();
		fitted.add(new Fit(768, 65535, true));
		
		for (BlockFit bf : blockFits) {
			if (bf.start != 1) {
				insertAt(fitted, bf, bf.start, bf.size);
				sorted.remove(bf);
			}
		}
		
		Collections.sort(sorted, Comparator.comparingInt(x -> x.size));
		Collections.reverse(sorted);
		
		outer:
		for (BlockFit bf : sorted) {
			for (int i=0; i<fitted.size(); i++) {
				Fit f = fitted.get(i);
				if (f.free) {
					if (f.width <= bf.size) {
						insertAt(fitted, bf, f.start, bf.size);
						continue outer;
					}
				}
			}
		}		
	}

	private void insertAt(List<Fit> fitted, BlockFit bf, int start, int size) {
		for (int i=0; i<fitted.size(); i++) {
			Fit f = fitted.get(i);
			if (f.start >= start && start+size <= f.start+f.width) {
				if (!f.free)
					throw new AssemblyException("Block overflow, can't fit block " + bf.units.get(0).getBlockName());
				Fit f2 = new Fit(start, size, false);
				bf.start = f2.start;
				f.start += bf.size;
				f.width -= bf.size;
				if (f.width == 0) {
					fitted.set(i, f2);
				} else {
					fitted.add(i, f2);
				}
				return;
			}
		}
	}

	private Map<String, AssembledUnit> flatten() {
		HashMap<String, AssembledUnit> flattened = new HashMap<String, AssembledUnit>();
		
		for (AssembledUnit au : linkedUnits) {
			if (flattened.containsKey(au.getBlockName()))
				throw new AssemblyException(String.format("Duplicate block names are not allowed. Name clash between %s (%s) and %s (%s)", 
						au.getBlockName(), flattened.get(au.getBlockName()).getSrcFile(), au.getBlockName(), au.getSrcFile()));
			flattened.put(au.getBlockName(), au);
		}
		
		return flattened;
	}

}
