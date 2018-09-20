package com.github.enerccio.e8.e8_asm;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import com.github.enerccio.e8.e8_asm.AssembledUnit.AddressMode;
import com.github.enerccio.e8.e8_asm.expr.BitPartExpression;
import com.github.enerccio.e8.e8_asm.expr.ConstantExpression;
import com.github.enerccio.e8.e8_asm.expr.MemoryExpression;
import com.github.enerccio.e8.e8_asm.expr.PlusExpression;
import com.github.enerccio.e8.e8_asm.inst.CPC;
import com.github.enerccio.e8.e8_asm.inst.FLAGS;
import com.github.enerccio.e8.e8_asm.inst.GBIT;
import com.github.enerccio.e8.e8_asm.inst.HLT;
import com.github.enerccio.e8.e8_asm.inst.INTR;
import com.github.enerccio.e8.e8_asm.inst.IOR;
import com.github.enerccio.e8.e8_asm.inst.IOW;
import com.github.enerccio.e8.e8_asm.inst.JMPZ;
import com.github.enerccio.e8.e8_asm.inst.LCONST;
import com.github.enerccio.e8.e8_asm.inst.LDSG;
import com.github.enerccio.e8.e8_asm.inst.LOAD;
import com.github.enerccio.e8.e8_asm.inst.MATH;
import com.github.enerccio.e8.e8_asm.inst.NOP;
import com.github.enerccio.e8.e8_asm.inst.POPA;
import com.github.enerccio.e8.e8_asm.inst.POPB;
import com.github.enerccio.e8.e8_asm.inst.POPPCP;
import com.github.enerccio.e8.e8_asm.inst.POPSG1;
import com.github.enerccio.e8.e8_asm.inst.PUSHA;
import com.github.enerccio.e8.e8_asm.inst.PUSHB;
import com.github.enerccio.e8.e8_asm.inst.PUSHCPC;
import com.github.enerccio.e8.e8_asm.inst.PUSHSG1;
import com.github.enerccio.e8.e8_asm.inst.SJMPZ;
import com.github.enerccio.e8.e8_asm.inst.STORE;
import com.github.enerccio.e8.e8_asm.inst.STP;
import com.github.enerccio.e8.e8_asm.inst.SWPACC;
import com.github.enerccio.e8.e8_asm.inst.SWPSG;
import com.github.enerccio.e8.e8_asm.inst.TCI;
import com.github.enerccio.e8.e8_asm.inst.TDBG;
import com.github.enerccio.e8.parser.e8asmLexer;
import com.github.enerccio.e8.parser.e8asmParser;
import com.github.enerccio.e8.parser.e8asmParser.AsmUnitContext;
import com.github.enerccio.e8.parser.e8asmParser.AssemblerCommandContext;
import com.github.enerccio.e8.parser.e8asmParser.BlockCommandsContext;
import com.github.enerccio.e8.parser.e8asmParser.BlockContext;
import com.github.enerccio.e8.parser.e8asmParser.CmdArgsContext;
import com.github.enerccio.e8.parser.e8asmParser.CommandContext;
import com.github.enerccio.e8.parser.e8asmParser.ConstantContext;
import com.github.enerccio.e8.parser.e8asmParser.DefinitionContext;
import com.github.enerccio.e8.parser.e8asmParser.ExprContext;

public class AssemblerUnit {
	
	public static class MacroDef {
		private int paramCount;
		private String content;
	}	

	private File srcFile;
	private boolean library;
	private boolean libraryMacro;
	private Map<String, MacroDef> globalMacros;
	
	public AssemblerUnit(File file, boolean library, boolean libraryMacro) {
		this.setSrcFile(file);
		this.setLibrary(library);
		this.setLibraryMacro(libraryMacro);
	}

	public List<AssembledUnit> assemble() throws Exception {
		Map<String, MacroDef> macros = new HashMap<String, MacroDef>();
		
		byte[] data = IOUtils.toByteArray(new FileInputStream(srcFile));
		
		ByteArrayInputStream finalAssembly = parseMacros(isLibraryMacro() ? globalMacros : macros, data);
		
		if (isLibraryMacro())
			return null; // macros do not compile
		
		data = IOUtils.toByteArray(finalAssembly);
		finalAssembly = expandMacros(data, macros);
		
		List<AssembledUnit> aus = new ArrayList<AssembledUnit>();
		e8asmLexer lexer = new e8asmLexer(new ANTLRInputStream(finalAssembly));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		e8asmParser parser = new e8asmParser(tokens);

		AsmUnitContext ctx = parser.asmUnit();
		
		for (DefinitionContext dctx : ctx.definition()) {
			BlockContext bctx = dctx.block();
			
			AssembledUnit au = new AssembledUnit();
			au.setSrcFile(srcFile);
			au.setLine(bctx.start.getLine());
			
			assembleBlock(au, bctx, aus.isEmpty() ? null : aus.get(aus.size() - 1));
			
			aus.add(au);
		}
		
		return aus;
	}

	private ByteArrayInputStream parseMacros(Map<String, MacroDef> macros, byte[] data) throws Exception {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		e8asmLexer lexer = new e8asmLexer(new ANTLRFileStream(srcFile.getAbsolutePath(), "utf-8"));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		e8asmParser parser = new e8asmParser(tokens);
		
		AsmUnitContext auc = parser.asmUnit();
		
		for (DefinitionContext dc : auc.definition()) {
			if (dc.block() != null) {
				bos.write(getText(data, dc.start, dc.stop));
			} else {
				MacroDef md = new MacroDef();
				md.content = new String(getText(data, dc.macro().macroBody().start, 
						dc.macro().macroBody().stop), Charset.forName("UTF-8"));
				md.paramCount = parseConstInt(dc.macro().paramCount().getText());
				macros.put(dc.macro().identifier().getText(), md);
			}
		}
		
		bos.flush();
		return new ByteArrayInputStream(bos.toByteArray());
	}

	private void assembleBlock(AssembledUnit au, BlockContext ctx, AssembledUnit previous) throws Exception {
		String blockName = ctx.blockName().identifier().getText();
		au.setBlockName(blockName);
		au.setMode(AddressMode.PREVIOUS);
		if (previous != null) 
			previous.setNext(au);
		au.setLibrary(library);
		
		if (ctx.blockName().blockAddress() != null) {
			String addr = ctx.blockName().blockAddress().addrType().getText();
			if ("SYSTEM".equals(addr)) {
				au.setMode(AddressMode.SYSTEM); 
			} else if ("ANYWHERE".equals(addr)) {
				au.setMode(AddressMode.USER);
			} else {
				au.setMode(AddressMode.STATIC);
				au.setAddress(Integer.parseInt(addr));
			}
		}
		
		for (BlockCommandsContext bctx : ctx.blockCommands()) {
			parseCommand(au, bctx);
		}
	}

	private void parseCommand(AssembledUnit au, BlockCommandsContext ctx) throws Exception {
		if (ctx.label() != null) {
			String label = ctx.label().compoundIdentifier().getText();
			if (label.contains(".")) {
				// interal label
				if (au.getLastLabel() == null)
					throw new AssemblyException("Internal label defined before main label");
				String internalLabel = label.substring(1);
				au.getInternalLabels().put(au.getLastLabel() + "." + internalLabel, au.getOperations().size());
			} else {
				au.getLabels().put(label, au.getOperations().size());
			}
		}
		
		AssemblerCommandContext actx = ctx.assemblerCommand();
		
		if (actx.constant() != null) {
			parseConstant(au, actx.constant());
		} else {
			parseCommand(au, actx.command());
		}
	}
	
	private ByteArrayInputStream expandMacros(byte[] data, Map<String, MacroDef> macros) throws Exception {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		e8asmLexer lexer = new e8asmLexer(new ANTLRInputStream(new ByteArrayInputStream(data)));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		e8asmParser parser = new e8asmParser(tokens);
		
		AsmUnitContext ctx = parser.asmUnit();
		
		for (DefinitionContext dctx : ctx.definition()) {
			BlockContext bctx = dctx.block();
			bos.write(getText(data, bctx.blockName().start, bctx.blockName().stop));
			bos.write("\n".getBytes(Charset.forName("UTF-8")));
			
			for (BlockCommandsContext c : bctx.blockCommands()) {
				MacroDef md;
				if (c.assemblerCommand().command() != null && (md = getMacro(c.assemblerCommand().command().identifier().getText(), macros)) != null) {
					CmdArgsContext cc = c.assemblerCommand().command().cmdArgs();
					List<String> args = new ArrayList<String>();
					if (cc != null) {
						for (ExprContext ec : cc.expr()) {
							args.add(ec.getText());
						}
					}
					if (md.paramCount != args.size()) {
						throw new AssemblyException("Bad argument count to macro " + c.assemblerCommand().command().identifier().getText());
					} else {
						if (c.label() != null) {
							bos.write(getText(data, c.label().start, c.label().stop));
						}
						bos.write(replaceMacroContent(md.content, args).getBytes(Charset.forName("UTF-8")));
					}
				} else {
					bos.write(getText(data, c.start, c.stop));
				}
			}
		}
		
		bos.flush();
		return new ByteArrayInputStream(bos.toByteArray());
	}

	private MacroDef getMacro(String key, Map<String, MacroDef> macros) {
		MacroDef md = macros.get(key); 
		if (md == null) {
			md = globalMacros.get(key);
		}
		return md;
	}

	private byte[] getText(byte[] data, Token start, Token end) {
		return Arrays.copyOfRange(data, start.getStartIndex(), Math.min(end.getStopIndex()+1, data.length));
	}

	private String replaceMacroContent(String content, List<String> args) {
		for (int i=0; i<args.size(); i++) {
			String aid = "&" + (i+1);
			content = StringUtils.replace(content, aid, args.get(i));
		}
		return content + "\n";
	}

	private void parseCommand(AssembledUnit au, CommandContext command) throws Exception {
		
		String cmd = command.identifier().getText();
		List<Expression> args = parseArgs(au, command);
		
		switch (cmd) {
		case "NOP": 
			warnNotEmpty(command.start, args);
			au.getOperations().add(new NOP());
			break;
		
		case "FLAGS": 
			warnNotEmpty(command.start, args);
			au.getOperations().add(new FLAGS());
			break;
			
		case "STP": 
			warnNotEmpty(command.start, args);
			au.getOperations().add(new STP());
			break;
			
		case "CPC": 
			warnNotEmpty(command.start, args);
			au.getOperations().add(new CPC());
			break;
			
		case "SWPACC":
			warnNotEmpty(command.start, args);
			au.getOperations().add(new SWPACC());
			break;
			
		case "SWPSG":
			warnNotEmpty(command.start, args);
			au.getOperations().add(new SWPSG());
			break;
			
		case "TDBG":
			warnNotEmpty(command.start, args);
			au.getOperations().add(new TDBG());
			break;
			
		case "TCI":
			warnNotEmpty(command.start, args);
			au.getOperations().add(new TCI());
			break;
		
		case "INTR":
			warnNotEmpty(command.start, args);
			au.getOperations().add(new INTR());
			break;
			
		case "IOR":
			warnNotEmpty(command.start, args);
			au.getOperations().add(new IOR());
			break;
			
		case "IOW":
			warnNotEmpty(command.start, args);
			au.getOperations().add(new IOW());
			break;
		
		case "HLT":
			warnNotEmpty(command.start, args);
			au.getOperations().add(new HLT());
			break;
			
		case "PUSHA":
			warnNotEmpty(command.start, args);
			au.getOperations().add(new PUSHA());
			break;
			
		case "POPA":
			warnNotEmpty(command.start, args);
			au.getOperations().add(new POPA());
			break;
			
		case "PUSHB":
			warnNotEmpty(command.start, args);
			au.getOperations().add(new PUSHB());
			break;
			
		case "POPB":
			warnNotEmpty(command.start, args);
			au.getOperations().add(new POPB());
			break;
		
		case "PUSH_SG":
			warnNotEmpty(command.start, args);
			au.getOperations().add(new PUSHSG1());
			break;
			
		case "POP_SG":
			warnNotEmpty(command.start, args);
			au.getOperations().add(new POPSG1());
			break;
			
		case "PUSH_CPC":
			warnNotEmpty(command.start, args);
			au.getOperations().add(new PUSHCPC());
			break;
			
		case "POP_CPC":
			warnNotEmpty(command.start, args);
			au.getOperations().add(new POPPCP());
			break;
			
		case "SL":
			warnNotEmpty(command.start, args);
			au.getOperations().add(MATH.shiftLeft());
			break;
	
		case "PLUS":
			warnNotEmpty(command.start, args);
			au.getOperations().add(MATH.plus());
			break;
			
		case "MINUS":
			warnNotEmpty(command.start, args);
			au.getOperations().add(MATH.minus());
			break;
			
		case "AND":
			warnNotEmpty(command.start, args);
			au.getOperations().add(MATH.and());
			break;
			
		case "OR":
			warnNotEmpty(command.start, args);
			au.getOperations().add(MATH.or());
			break;
			
		case "XOR":
			warnNotEmpty(command.start, args);
			au.getOperations().add(MATH.xor());
			break;
			
		case "NEG":
			warnNotEmpty(command.start, args);
			au.getOperations().add(MATH.neg());
			break;
			
		case "SR":
			warnNotEmpty(command.start, args);
			au.getOperations().add(MATH.shiftRight());
			break;
			
		case "LOAD":
			throwBadCount(command.start, args, 1);
			au.getOperations().add(new LOAD(args.get(0)));
			break;
			
		case "STORE":
			throwBadCount(command.start, args, 1);
			au.getOperations().add(new STORE(args.get(0)));
			break;
			
		case "LCONST":
			throwBadCount(command.start, args, 1);
			au.getOperations().add(new LCONST(args.get(0)));
			break;
			
		case "GBIT":
			throwBadCount(command.start, args, 1);
			au.getOperations().add(new GBIT(args.get(0)));
			break;
			
		case "JMPZ":
			throwBadCount(command.start, args, 1);
			au.getOperations().add(new JMPZ(args.get(0)));
			break;
			
		case "SJMPZ":
			throwBadCount(command.start, args, 1);
			au.getOperations().add(new SJMPZ(args.get(0)));
			break;
			
		case "LDSG":
			throwBadCount(command.start, args, 2);
			au.getOperations().add(new LDSG(args.get(0), args.get(1)));
			break;
		}
	}

	private void throwBadCount(Token t, List<Expression> l, int expectedCount) {
		if (l.size() != expectedCount) {
			throw new AssemblyException("Bad argument count at file " + srcFile + ", line " + t.getLine() 
				+ ": expected " + expectedCount + ", got " + l.size());
		}
	}

	private void warnNotEmpty(Token t, List<Expression> args) {
		if (!args.isEmpty()) {
			System.err.println("Non empty args for empty operation at file " + srcFile + ", line " + t.getLine());
		}
	}

	private List<Expression> parseArgs(AssembledUnit au, CommandContext command) throws Exception {
		List<Expression> args = new ArrayList<Expression>();
		
		if (command.cmdArgs() != null) {
			for (ExprContext ectx : command.cmdArgs().expr()) {
				Expression e = parseExpression(au, ectx);
				args.add(e);
				au.getMrs().addAll(e.getResolvers());
			}
		}
		
		return args;
	}

	private Expression parseExpression(AssembledUnit au, ExprContext ctx) throws Exception {
		if (ctx.primary() != null) {
			if (ctx.primary().expr() != null) {
				return parseExpression(au, ctx.primary().expr());
			}
			
			if (ctx.primary().memory() != null) {
				if (ctx.primary().memory().localIdentifier() != null) {
					String localIdentifier = ctx.primary().memory().localIdentifier().getText().substring(1);
					return new MemoryExpression(new MemoryResolver(au.getBlockName(), au.getLastLabel(), localIdentifier));
				}
				String ids = ctx.primary().memory().identifiers().getText();
				if (!ids.contains(".")) {
					return new MemoryExpression(new MemoryResolver(au.getBlockName(), ids, null));
				} else {
					String block = ids.split(Pattern.quote("."))[0];
					String label = ids.split(Pattern.quote("."))[1];
					return new MemoryExpression(new MemoryResolver(block.equals(au.getBlockName()) ? null : block, label, null));
				}
			}
			
			if (ctx.primary().string() != null) {
				String v = ctx.primary().string().getText();
				if (v.length() > 1) {
					System.err.println("Longer string than 1 character at file " + srcFile + ", line " 
							+ ctx.primary().string().start.getLine());
				}
				return new ConstantExpression((short) v.getBytes()[0]);
			}
			
			String sv = ctx.primary().integer().getText();
			short pc = parseConstInt(sv);
			return new ConstantExpression(pc);
		} else {
			if (ctx.plusExpr() != null) {
				return new PlusExpression(parseExpression(au, ctx.expr(0)), parseExpression(au, ctx.expr(1)));
			} else if (ctx.minusExpr() != null) {
				return new PlusExpression(parseExpression(au, ctx.expr(0)), parseExpression(au, ctx.expr(1)));
			} else {
				String sb = ctx.bitPart().integer(0).getText();
				String eb = ctx.bitPart().integer(1).getText();
				
				return new BitPartExpression(parseExpression(au, ctx.expr(0)), (byte) parseConstInt(sb), (byte) parseConstInt(eb));
			}
		}
	}

	private short parseConstInt(String sv) {
		sv = sv.toLowerCase();
		
		if (sv.length() == 1)
			return (short) Integer.parseInt(sv);
		
		if (sv.startsWith("0")) {
			return (short) Integer.parseInt(sv.substring(1), 8);
		}
		
		if (sv.startsWith("0b")) {
			return (short) Integer.parseInt(sv.substring(2), 2);
		}
		
		if (sv.startsWith("0x")) {
			return (short) Integer.parseInt(sv.substring(2), 16);
		}
		
		return (short) Integer.parseInt(sv);
	}

	private void parseConstant(AssembledUnit au, ConstantContext ctx) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public File getSrcFile() {
		return srcFile;
	}

	public void setSrcFile(File srcFile) {
		this.srcFile = srcFile;
	}

	public boolean isLibrary() {
		return library;
	}

	public void setLibrary(boolean library) {
		this.library = library;
	}

	public boolean isLibraryMacro() {
		return libraryMacro;
	}

	public void setLibraryMacro(boolean libraryMacro) {
		this.libraryMacro = libraryMacro;
	}

	public Map<String, MacroDef> getGlobalMacros() {
		return globalMacros;
	}

	public void setGlobalMacros(Map<String, MacroDef> globalMacros) {
		this.globalMacros = globalMacros;
	}

}
