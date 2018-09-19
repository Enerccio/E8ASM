package com.github.enerccio.e8.e8_asm;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AssembledUnit {
	
	public enum AddressMode {
		
		STATIC, SYSTEM, USER, PREVIOUS
		
	}
	
	private File srcFile;
	private int line;
	private boolean isLibrary;
	private String blockName;
	private Set<String> requestedOutboundLinks = new HashSet<String>();
	private List<Instruction> operations = new ArrayList<Instruction>();
	private AddressMode mode;
	private Map<String, Integer> labels = new HashMap<String, Integer>();
	private Map<String, Integer> internalLabels = new HashMap<String, Integer>();
	private String lastLabel;
	private AssembledUnit next;
	private Integer address;
	private List<MemoryResolver> mrs = new ArrayList<MemoryResolver>();
	
	public Set<String> getUnresolvedBlocks() {
		HashSet<String> blocks = new HashSet<String>();
		
		for (MemoryResolver mr : mrs) {
			if (mr.getModule() != null) {
				blocks.add(mr.getModule());
			}
		}
		
		return blocks;
	}

	public File getSrcFile() {
		return srcFile;
	}

	public void setSrcFile(File srcFile) {
		this.srcFile = srcFile;
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public String getBlockName() {
		return blockName;
	}

	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}

	public Set<String> getRequestedOutboundLinks() {
		return requestedOutboundLinks;
	}

	public AddressMode getMode() {
		return mode;
	}

	public void setMode(AddressMode mode) {
		this.mode = mode;
	}

	public List<Instruction> getOperations() {
		return operations;
	}

	public Map<String, Integer> getLabels() {
		return labels;
	}
	
	public Integer getAddress() {
		return address;
	}

	public void setAddress(Integer address) {
		this.address = address;
	}

	public Map<String, Integer> getInternalLabels() {
		return internalLabels;
	}

	public String getLastLabel() {
		return lastLabel;
	}

	public void setLastLabel(String lastLabel) {
		this.lastLabel = lastLabel;
	}

	public List<MemoryResolver> getMrs() {
		return mrs;
	}

	public void setMrs(List<MemoryResolver> mrs) {
		this.mrs = mrs;
	}

	public boolean isLibrary() {
		return isLibrary;
	}

	public void setLibrary(boolean isLibrary) {
		this.isLibrary = isLibrary;
	}

	public AssembledUnit getNext() {
		return next;
	}

	public void setNext(AssembledUnit next) {
		this.next = next;
	}

}
