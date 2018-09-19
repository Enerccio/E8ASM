// Generated from com/github/enerccio/e8/parser/e8asm.g4 by ANTLR 4.3
package com.github.enerccio.e8.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class e8asmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__18=1, T__17=2, T__16=3, T__15=4, T__14=5, T__13=6, T__12=7, T__11=8, 
		T__10=9, T__9=10, T__8=11, T__7=12, T__6=13, T__5=14, T__4=15, T__3=16, 
		T__2=17, T__1=18, T__0=19, IntegerLiteral=20, StringLiteral=21, Identifier=22, 
		WS=23, COMMENT=24, LINE_COMMENT=25;
	public static final String[] tokenNames = {
		"<INVALID>", "'SYSTEM'", "'SECTION'", "':'", "'ADDRESS'", "'['", "';'", 
		"']'", "'ENDMACRO'", "'DDD'", "'$'", "'MACRO'", "'&'", "'('", "'ANYWHERE'", 
		"')'", "'+'", "','", "'-'", "'.'", "IntegerLiteral", "StringLiteral", 
		"Identifier", "WS", "COMMENT", "LINE_COMMENT"
	};
	public static final int
		RULE_asmUnit = 0, RULE_definition = 1, RULE_macro = 2, RULE_paramCount = 3, 
		RULE_macroBody = 4, RULE_block = 5, RULE_blockCommands = 6, RULE_blockName = 7, 
		RULE_blockAddress = 8, RULE_addrType = 9, RULE_label = 10, RULE_compoundIdentifier = 11, 
		RULE_assemblerCommand = 12, RULE_assemblerMacroCommand = 13, RULE_constant = 14, 
		RULE_macroConstant = 15, RULE_command = 16, RULE_macroCommand = 17, RULE_macroIdentifier = 18, 
		RULE_macroId = 19, RULE_cmdArgs = 20, RULE_macroCmdArgs = 21, RULE_expr = 22, 
		RULE_macroExpr = 23, RULE_bitPart = 24, RULE_plusExpr = 25, RULE_minusExpr = 26, 
		RULE_primary = 27, RULE_macroPrimary = 28, RULE_memory = 29, RULE_identifiers = 30, 
		RULE_localIdentifier = 31, RULE_integer = 32, RULE_string = 33, RULE_identifier = 34;
	public static final String[] ruleNames = {
		"asmUnit", "definition", "macro", "paramCount", "macroBody", "block", 
		"blockCommands", "blockName", "blockAddress", "addrType", "label", "compoundIdentifier", 
		"assemblerCommand", "assemblerMacroCommand", "constant", "macroConstant", 
		"command", "macroCommand", "macroIdentifier", "macroId", "cmdArgs", "macroCmdArgs", 
		"expr", "macroExpr", "bitPart", "plusExpr", "minusExpr", "primary", "macroPrimary", 
		"memory", "identifiers", "localIdentifier", "integer", "string", "identifier"
	};

	@Override
	public String getGrammarFileName() { return "e8asm.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public e8asmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class AsmUnitContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(e8asmParser.EOF, 0); }
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public AsmUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asmUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).enterAsmUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).exitAsmUnit(this);
		}
	}

	public final AsmUnitContext asmUnit() throws RecognitionException {
		AsmUnitContext _localctx = new AsmUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_asmUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(70); definition();
				}
				}
				setState(73); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__17 || _la==T__8 );
			setState(75); match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefinitionContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public MacroContext macro() {
			return getRuleContext(MacroContext.class,0);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).enterDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).exitDefinition(this);
		}
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_definition);
		try {
			setState(79);
			switch (_input.LA(1)) {
			case T__17:
				enterOuterAlt(_localctx, 1);
				{
				setState(77); block();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(78); macro();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MacroContext extends ParserRuleContext {
		public MacroBodyContext macroBody() {
			return getRuleContext(MacroBodyContext.class,0);
		}
		public ParamCountContext paramCount() {
			return getRuleContext(ParamCountContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public MacroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macro; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).enterMacro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).exitMacro(this);
		}
	}

	public final MacroContext macro() throws RecognitionException {
		MacroContext _localctx = new MacroContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_macro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81); match(T__8);
			setState(82); identifier();
			setState(83); paramCount();
			setState(84); macroBody();
			setState(85); match(T__11);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamCountContext extends ParserRuleContext {
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public ParamCountContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramCount; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).enterParamCount(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).exitParamCount(this);
		}
	}

	public final ParamCountContext paramCount() throws RecognitionException {
		ParamCountContext _localctx = new ParamCountContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_paramCount);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87); integer();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MacroBodyContext extends ParserRuleContext {
		public AssemblerMacroCommandContext assemblerMacroCommand(int i) {
			return getRuleContext(AssemblerMacroCommandContext.class,i);
		}
		public List<AssemblerMacroCommandContext> assemblerMacroCommand() {
			return getRuleContexts(AssemblerMacroCommandContext.class);
		}
		public MacroBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macroBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).enterMacroBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).exitMacroBody(this);
		}
	}

	public final MacroBodyContext macroBody() throws RecognitionException {
		MacroBodyContext _localctx = new MacroBodyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_macroBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__7) | (1L << Identifier))) != 0)) {
				{
				{
				setState(89); assemblerMacroCommand();
				setState(90); match(T__13);
				}
				}
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<BlockCommandsContext> blockCommands() {
			return getRuleContexts(BlockCommandsContext.class);
		}
		public BlockNameContext blockName() {
			return getRuleContext(BlockNameContext.class,0);
		}
		public BlockCommandsContext blockCommands(int i) {
			return getRuleContext(BlockCommandsContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97); blockName();
			setState(99); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(98); blockCommands();
				}
				}
				setState(101); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__0) | (1L << Identifier))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockCommandsContext extends ParserRuleContext {
		public AssemblerCommandContext assemblerCommand() {
			return getRuleContext(AssemblerCommandContext.class,0);
		}
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public BlockCommandsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockCommands; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).enterBlockCommands(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).exitBlockCommands(this);
		}
	}

	public final BlockCommandsContext blockCommands() throws RecognitionException {
		BlockCommandsContext _localctx = new BlockCommandsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_blockCommands);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(104);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(103); label();
				}
				break;
			}
			setState(106); assemblerCommand();
			setState(107); match(T__13);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockNameContext extends ParserRuleContext {
		public BlockAddressContext blockAddress() {
			return getRuleContext(BlockAddressContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public BlockNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).enterBlockName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).exitBlockName(this);
		}
	}

	public final BlockNameContext blockName() throws RecognitionException {
		BlockNameContext _localctx = new BlockNameContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_blockName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109); match(T__17);
			setState(110); identifier();
			setState(112);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(111); blockAddress();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockAddressContext extends ParserRuleContext {
		public AddrTypeContext addrType() {
			return getRuleContext(AddrTypeContext.class,0);
		}
		public BlockAddressContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockAddress; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).enterBlockAddress(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).exitBlockAddress(this);
		}
	}

	public final BlockAddressContext blockAddress() throws RecognitionException {
		BlockAddressContext _localctx = new BlockAddressContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_blockAddress);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(114); match(T__15);
			setState(115); addrType();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddrTypeContext extends ParserRuleContext {
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public AddrTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addrType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).enterAddrType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).exitAddrType(this);
		}
	}

	public final AddrTypeContext addrType() throws RecognitionException {
		AddrTypeContext _localctx = new AddrTypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_addrType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			switch (_input.LA(1)) {
			case IntegerLiteral:
				{
				setState(117); integer();
				}
				break;
			case T__5:
				{
				setState(118); match(T__5);
				}
				break;
			case T__18:
				{
				setState(119); match(T__18);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LabelContext extends ParserRuleContext {
		public CompoundIdentifierContext compoundIdentifier() {
			return getRuleContext(CompoundIdentifierContext.class,0);
		}
		public LabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).enterLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).exitLabel(this);
		}
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_label);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122); compoundIdentifier();
			setState(123); match(T__16);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompoundIdentifierContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public CompoundIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).enterCompoundIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).exitCompoundIdentifier(this);
		}
	}

	public final CompoundIdentifierContext compoundIdentifier() throws RecognitionException {
		CompoundIdentifierContext _localctx = new CompoundIdentifierContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_compoundIdentifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(125); match(T__0);
				}
			}

			setState(128); identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssemblerCommandContext extends ParserRuleContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public CommandContext command() {
			return getRuleContext(CommandContext.class,0);
		}
		public AssemblerCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assemblerCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).enterAssemblerCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).exitAssemblerCommand(this);
		}
	}

	public final AssemblerCommandContext assemblerCommand() throws RecognitionException {
		AssemblerCommandContext _localctx = new AssemblerCommandContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_assemblerCommand);
		try {
			setState(132);
			switch (_input.LA(1)) {
			case T__10:
				enterOuterAlt(_localctx, 1);
				{
				setState(130); constant();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(131); command();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssemblerMacroCommandContext extends ParserRuleContext {
		public MacroConstantContext macroConstant() {
			return getRuleContext(MacroConstantContext.class,0);
		}
		public MacroCommandContext macroCommand() {
			return getRuleContext(MacroCommandContext.class,0);
		}
		public AssemblerMacroCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assemblerMacroCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).enterAssemblerMacroCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).exitAssemblerMacroCommand(this);
		}
	}

	public final AssemblerMacroCommandContext assemblerMacroCommand() throws RecognitionException {
		AssemblerMacroCommandContext _localctx = new AssemblerMacroCommandContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_assemblerMacroCommand);
		try {
			setState(136);
			switch (_input.LA(1)) {
			case T__10:
				enterOuterAlt(_localctx, 1);
				{
				setState(134); macroConstant();
				}
				break;
			case T__7:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(135); macroCommand();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).exitConstant(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_constant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138); match(T__10);
			setState(139); expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MacroConstantContext extends ParserRuleContext {
		public MacroExprContext macroExpr() {
			return getRuleContext(MacroExprContext.class,0);
		}
		public MacroConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macroConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).enterMacroConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).exitMacroConstant(this);
		}
	}

	public final MacroConstantContext macroConstant() throws RecognitionException {
		MacroConstantContext _localctx = new MacroConstantContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_macroConstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141); match(T__10);
			setState(142); macroExpr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CommandContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public CmdArgsContext cmdArgs() {
			return getRuleContext(CmdArgsContext.class,0);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).enterCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).exitCommand(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_command);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144); identifier();
			setState(146);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__6) | (1L << IntegerLiteral) | (1L << StringLiteral))) != 0)) {
				{
				setState(145); cmdArgs();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MacroCommandContext extends ParserRuleContext {
		public MacroIdentifierContext macroIdentifier() {
			return getRuleContext(MacroIdentifierContext.class,0);
		}
		public MacroCmdArgsContext macroCmdArgs() {
			return getRuleContext(MacroCmdArgsContext.class,0);
		}
		public MacroCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macroCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).enterMacroCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).exitMacroCommand(this);
		}
	}

	public final MacroCommandContext macroCommand() throws RecognitionException {
		MacroCommandContext _localctx = new MacroCommandContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_macroCommand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148); macroIdentifier();
			setState(150);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__7) | (1L << T__6) | (1L << IntegerLiteral) | (1L << StringLiteral))) != 0)) {
				{
				setState(149); macroCmdArgs();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MacroIdentifierContext extends ParserRuleContext {
		public MacroIdContext macroId() {
			return getRuleContext(MacroIdContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public MacroIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macroIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).enterMacroIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).exitMacroIdentifier(this);
		}
	}

	public final MacroIdentifierContext macroIdentifier() throws RecognitionException {
		MacroIdentifierContext _localctx = new MacroIdentifierContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_macroIdentifier);
		try {
			setState(154);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(152); identifier();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(153); macroId();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MacroIdContext extends ParserRuleContext {
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public MacroIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macroId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).enterMacroId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).exitMacroId(this);
		}
	}

	public final MacroIdContext macroId() throws RecognitionException {
		MacroIdContext _localctx = new MacroIdContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_macroId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156); match(T__7);
			setState(157); integer();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdArgsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public CmdArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).enterCmdArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).exitCmdArgs(this);
		}
	}

	public final CmdArgsContext cmdArgs() throws RecognitionException {
		CmdArgsContext _localctx = new CmdArgsContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_cmdArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159); expr(0);
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(160); match(T__2);
				setState(161); expr(0);
				}
				}
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MacroCmdArgsContext extends ParserRuleContext {
		public MacroExprContext macroExpr(int i) {
			return getRuleContext(MacroExprContext.class,i);
		}
		public List<MacroExprContext> macroExpr() {
			return getRuleContexts(MacroExprContext.class);
		}
		public MacroCmdArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macroCmdArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).enterMacroCmdArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).exitMacroCmdArgs(this);
		}
	}

	public final MacroCmdArgsContext macroCmdArgs() throws RecognitionException {
		MacroCmdArgsContext _localctx = new MacroCmdArgsContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_macroCmdArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167); macroExpr(0);
			setState(172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(168); match(T__2);
				setState(169); macroExpr(0);
				}
				}
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BitPartContext bitPart() {
			return getRuleContext(BitPartContext.class,0);
		}
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public PlusExprContext plusExpr() {
			return getRuleContext(PlusExprContext.class,0);
		}
		public MinusExprContext minusExpr() {
			return getRuleContext(MinusExprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(176); primary();
			}
			_ctx.stop = _input.LT(-1);
			setState(190);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(188);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(178);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(179); plusExpr();
						setState(180); expr(4);
						}
						break;

					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(182);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(183); minusExpr();
						setState(184); expr(3);
						}
						break;

					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(186);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(187); bitPart();
						}
						break;
					}
					} 
				}
				setState(192);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MacroExprContext extends ParserRuleContext {
		public MacroExprContext macroExpr(int i) {
			return getRuleContext(MacroExprContext.class,i);
		}
		public MacroPrimaryContext macroPrimary() {
			return getRuleContext(MacroPrimaryContext.class,0);
		}
		public BitPartContext bitPart() {
			return getRuleContext(BitPartContext.class,0);
		}
		public List<MacroExprContext> macroExpr() {
			return getRuleContexts(MacroExprContext.class);
		}
		public PlusExprContext plusExpr() {
			return getRuleContext(PlusExprContext.class,0);
		}
		public MinusExprContext minusExpr() {
			return getRuleContext(MinusExprContext.class,0);
		}
		public MacroExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macroExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).enterMacroExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).exitMacroExpr(this);
		}
	}

	public final MacroExprContext macroExpr() throws RecognitionException {
		return macroExpr(0);
	}

	private MacroExprContext macroExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MacroExprContext _localctx = new MacroExprContext(_ctx, _parentState);
		MacroExprContext _prevctx = _localctx;
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_macroExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(194); macroPrimary();
			}
			_ctx.stop = _input.LT(-1);
			setState(208);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(206);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new MacroExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_macroExpr);
						setState(196);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(197); plusExpr();
						setState(198); macroExpr(4);
						}
						break;

					case 2:
						{
						_localctx = new MacroExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_macroExpr);
						setState(200);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(201); minusExpr();
						setState(202); macroExpr(3);
						}
						break;

					case 3:
						{
						_localctx = new MacroExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_macroExpr);
						setState(204);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(205); bitPart();
						}
						break;
					}
					} 
				}
				setState(210);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BitPartContext extends ParserRuleContext {
		public List<IntegerContext> integer() {
			return getRuleContexts(IntegerContext.class);
		}
		public IntegerContext integer(int i) {
			return getRuleContext(IntegerContext.class,i);
		}
		public BitPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).enterBitPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).exitBitPart(this);
		}
	}

	public final BitPartContext bitPart() throws RecognitionException {
		BitPartContext _localctx = new BitPartContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_bitPart);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211); match(T__14);
			setState(212); integer();
			setState(213); match(T__16);
			setState(214); integer();
			setState(215); match(T__12);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PlusExprContext extends ParserRuleContext {
		public PlusExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plusExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).enterPlusExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).exitPlusExpr(this);
		}
	}

	public final PlusExprContext plusExpr() throws RecognitionException {
		PlusExprContext _localctx = new PlusExprContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_plusExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217); match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MinusExprContext extends ParserRuleContext {
		public MinusExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_minusExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).enterMinusExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).exitMinusExpr(this);
		}
	}

	public final MinusExprContext minusExpr() throws RecognitionException {
		MinusExprContext _localctx = new MinusExprContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_minusExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219); match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryContext extends ParserRuleContext {
		public MemoryContext memory() {
			return getRuleContext(MemoryContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).exitPrimary(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_primary);
		try {
			setState(228);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(221); match(T__6);
				setState(222); expr(0);
				setState(223); match(T__4);
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(225); memory();
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(226); string();
				}
				break;
			case IntegerLiteral:
				enterOuterAlt(_localctx, 4);
				{
				setState(227); integer();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MacroPrimaryContext extends ParserRuleContext {
		public MemoryContext memory() {
			return getRuleContext(MemoryContext.class,0);
		}
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public MacroExprContext macroExpr() {
			return getRuleContext(MacroExprContext.class,0);
		}
		public MacroPrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macroPrimary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).enterMacroPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).exitMacroPrimary(this);
		}
	}

	public final MacroPrimaryContext macroPrimary() throws RecognitionException {
		MacroPrimaryContext _localctx = new MacroPrimaryContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_macroPrimary);
		try {
			setState(239);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(230); match(T__6);
				setState(231); macroExpr(0);
				setState(232); match(T__4);
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(234); memory();
				}
				break;
			case StringLiteral:
				enterOuterAlt(_localctx, 3);
				{
				setState(235); string();
				}
				break;
			case IntegerLiteral:
				enterOuterAlt(_localctx, 4);
				{
				setState(236); integer();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 5);
				{
				setState(237); match(T__7);
				setState(238); integer();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MemoryContext extends ParserRuleContext {
		public IdentifiersContext identifiers() {
			return getRuleContext(IdentifiersContext.class,0);
		}
		public LocalIdentifierContext localIdentifier() {
			return getRuleContext(LocalIdentifierContext.class,0);
		}
		public MemoryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memory; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).enterMemory(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).exitMemory(this);
		}
	}

	public final MemoryContext memory() throws RecognitionException {
		MemoryContext _localctx = new MemoryContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_memory);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241); match(T__9);
			setState(244);
			switch (_input.LA(1)) {
			case Identifier:
				{
				setState(242); identifiers();
				}
				break;
			case T__0:
				{
				setState(243); localIdentifier();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifiersContext extends ParserRuleContext {
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifiers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).enterIdentifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).exitIdentifiers(this);
		}
	}

	public final IdentifiersContext identifiers() throws RecognitionException {
		IdentifiersContext _localctx = new IdentifiersContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_identifiers);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246); identifier();
			setState(249);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(247); match(T__0);
				setState(248); identifier();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocalIdentifierContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public LocalIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).enterLocalIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).exitLocalIdentifier(this);
		}
	}

	public final LocalIdentifierContext localIdentifier() throws RecognitionException {
		LocalIdentifierContext _localctx = new LocalIdentifierContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_localIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251); match(T__0);
			setState(252); identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntegerContext extends ParserRuleContext {
		public TerminalNode IntegerLiteral() { return getToken(e8asmParser.IntegerLiteral, 0); }
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).exitInteger(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_integer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254); match(IntegerLiteral);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringContext extends ParserRuleContext {
		public TerminalNode StringLiteral() { return getToken(e8asmParser.StringLiteral, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).exitString(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256); match(StringLiteral);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(e8asmParser.Identifier, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof e8asmListener ) ((e8asmListener)listener).exitIdentifier(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258); match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 22: return expr_sempred((ExprContext)_localctx, predIndex);

		case 23: return macroExpr_sempred((MacroExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean macroExpr_sempred(MacroExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3: return precpred(_ctx, 3);

		case 4: return precpred(_ctx, 2);

		case 5: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 3);

		case 1: return precpred(_ctx, 2);

		case 2: return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\33\u0107\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\6\2J\n\2\r\2\16\2K\3\2\3\2\3\3\3\3\5\3R\n"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\7\6_\n\6\f\6\16\6b\13\6"+
		"\3\7\3\7\6\7f\n\7\r\7\16\7g\3\b\5\bk\n\b\3\b\3\b\3\b\3\t\3\t\3\t\5\ts"+
		"\n\t\3\n\3\n\3\n\3\13\3\13\3\13\5\13{\n\13\3\f\3\f\3\f\3\r\5\r\u0081\n"+
		"\r\3\r\3\r\3\16\3\16\5\16\u0087\n\16\3\17\3\17\5\17\u008b\n\17\3\20\3"+
		"\20\3\20\3\21\3\21\3\21\3\22\3\22\5\22\u0095\n\22\3\23\3\23\5\23\u0099"+
		"\n\23\3\24\3\24\5\24\u009d\n\24\3\25\3\25\3\25\3\26\3\26\3\26\7\26\u00a5"+
		"\n\26\f\26\16\26\u00a8\13\26\3\27\3\27\3\27\7\27\u00ad\n\27\f\27\16\27"+
		"\u00b0\13\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\7\30\u00bf\n\30\f\30\16\30\u00c2\13\30\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\7\31\u00d1\n\31\f\31\16\31"+
		"\u00d4\13\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3"+
		"\35\3\35\3\35\3\35\3\35\3\35\5\35\u00e7\n\35\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\5\36\u00f2\n\36\3\37\3\37\3\37\5\37\u00f7\n\37\3"+
		" \3 \3 \5 \u00fc\n \3!\3!\3!\3\"\3\"\3#\3#\3$\3$\3$\2\4.\60%\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDF\2\2\u0102\2"+
		"I\3\2\2\2\4Q\3\2\2\2\6S\3\2\2\2\bY\3\2\2\2\n`\3\2\2\2\fc\3\2\2\2\16j\3"+
		"\2\2\2\20o\3\2\2\2\22t\3\2\2\2\24z\3\2\2\2\26|\3\2\2\2\30\u0080\3\2\2"+
		"\2\32\u0086\3\2\2\2\34\u008a\3\2\2\2\36\u008c\3\2\2\2 \u008f\3\2\2\2\""+
		"\u0092\3\2\2\2$\u0096\3\2\2\2&\u009c\3\2\2\2(\u009e\3\2\2\2*\u00a1\3\2"+
		"\2\2,\u00a9\3\2\2\2.\u00b1\3\2\2\2\60\u00c3\3\2\2\2\62\u00d5\3\2\2\2\64"+
		"\u00db\3\2\2\2\66\u00dd\3\2\2\28\u00e6\3\2\2\2:\u00f1\3\2\2\2<\u00f3\3"+
		"\2\2\2>\u00f8\3\2\2\2@\u00fd\3\2\2\2B\u0100\3\2\2\2D\u0102\3\2\2\2F\u0104"+
		"\3\2\2\2HJ\5\4\3\2IH\3\2\2\2JK\3\2\2\2KI\3\2\2\2KL\3\2\2\2LM\3\2\2\2M"+
		"N\7\2\2\3N\3\3\2\2\2OR\5\f\7\2PR\5\6\4\2QO\3\2\2\2QP\3\2\2\2R\5\3\2\2"+
		"\2ST\7\r\2\2TU\5F$\2UV\5\b\5\2VW\5\n\6\2WX\7\n\2\2X\7\3\2\2\2YZ\5B\"\2"+
		"Z\t\3\2\2\2[\\\5\34\17\2\\]\7\b\2\2]_\3\2\2\2^[\3\2\2\2_b\3\2\2\2`^\3"+
		"\2\2\2`a\3\2\2\2a\13\3\2\2\2b`\3\2\2\2ce\5\20\t\2df\5\16\b\2ed\3\2\2\2"+
		"fg\3\2\2\2ge\3\2\2\2gh\3\2\2\2h\r\3\2\2\2ik\5\26\f\2ji\3\2\2\2jk\3\2\2"+
		"\2kl\3\2\2\2lm\5\32\16\2mn\7\b\2\2n\17\3\2\2\2op\7\4\2\2pr\5F$\2qs\5\22"+
		"\n\2rq\3\2\2\2rs\3\2\2\2s\21\3\2\2\2tu\7\6\2\2uv\5\24\13\2v\23\3\2\2\2"+
		"w{\5B\"\2x{\7\20\2\2y{\7\3\2\2zw\3\2\2\2zx\3\2\2\2zy\3\2\2\2{\25\3\2\2"+
		"\2|}\5\30\r\2}~\7\5\2\2~\27\3\2\2\2\177\u0081\7\25\2\2\u0080\177\3\2\2"+
		"\2\u0080\u0081\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0083\5F$\2\u0083\31"+
		"\3\2\2\2\u0084\u0087\5\36\20\2\u0085\u0087\5\"\22\2\u0086\u0084\3\2\2"+
		"\2\u0086\u0085\3\2\2\2\u0087\33\3\2\2\2\u0088\u008b\5 \21\2\u0089\u008b"+
		"\5$\23\2\u008a\u0088\3\2\2\2\u008a\u0089\3\2\2\2\u008b\35\3\2\2\2\u008c"+
		"\u008d\7\13\2\2\u008d\u008e\5.\30\2\u008e\37\3\2\2\2\u008f\u0090\7\13"+
		"\2\2\u0090\u0091\5\60\31\2\u0091!\3\2\2\2\u0092\u0094\5F$\2\u0093\u0095"+
		"\5*\26\2\u0094\u0093\3\2\2\2\u0094\u0095\3\2\2\2\u0095#\3\2\2\2\u0096"+
		"\u0098\5&\24\2\u0097\u0099\5,\27\2\u0098\u0097\3\2\2\2\u0098\u0099\3\2"+
		"\2\2\u0099%\3\2\2\2\u009a\u009d\5F$\2\u009b\u009d\5(\25\2\u009c\u009a"+
		"\3\2\2\2\u009c\u009b\3\2\2\2\u009d\'\3\2\2\2\u009e\u009f\7\16\2\2\u009f"+
		"\u00a0\5B\"\2\u00a0)\3\2\2\2\u00a1\u00a6\5.\30\2\u00a2\u00a3\7\23\2\2"+
		"\u00a3\u00a5\5.\30\2\u00a4\u00a2\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4"+
		"\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7+\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9"+
		"\u00ae\5\60\31\2\u00aa\u00ab\7\23\2\2\u00ab\u00ad\5\60\31\2\u00ac\u00aa"+
		"\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af"+
		"-\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1\u00b2\b\30\1\2\u00b2\u00b3\58\35\2"+
		"\u00b3\u00c0\3\2\2\2\u00b4\u00b5\f\5\2\2\u00b5\u00b6\5\64\33\2\u00b6\u00b7"+
		"\5.\30\6\u00b7\u00bf\3\2\2\2\u00b8\u00b9\f\4\2\2\u00b9\u00ba\5\66\34\2"+
		"\u00ba\u00bb\5.\30\5\u00bb\u00bf\3\2\2\2\u00bc\u00bd\f\3\2\2\u00bd\u00bf"+
		"\5\62\32\2\u00be\u00b4\3\2\2\2\u00be\u00b8\3\2\2\2\u00be\u00bc\3\2\2\2"+
		"\u00bf\u00c2\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1/\3"+
		"\2\2\2\u00c2\u00c0\3\2\2\2\u00c3\u00c4\b\31\1\2\u00c4\u00c5\5:\36\2\u00c5"+
		"\u00d2\3\2\2\2\u00c6\u00c7\f\5\2\2\u00c7\u00c8\5\64\33\2\u00c8\u00c9\5"+
		"\60\31\6\u00c9\u00d1\3\2\2\2\u00ca\u00cb\f\4\2\2\u00cb\u00cc\5\66\34\2"+
		"\u00cc\u00cd\5\60\31\5\u00cd\u00d1\3\2\2\2\u00ce\u00cf\f\3\2\2\u00cf\u00d1"+
		"\5\62\32\2\u00d0\u00c6\3\2\2\2\u00d0\u00ca\3\2\2\2\u00d0\u00ce\3\2\2\2"+
		"\u00d1\u00d4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\61"+
		"\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5\u00d6\7\7\2\2\u00d6\u00d7\5B\"\2\u00d7"+
		"\u00d8\7\5\2\2\u00d8\u00d9\5B\"\2\u00d9\u00da\7\t\2\2\u00da\63\3\2\2\2"+
		"\u00db\u00dc\7\22\2\2\u00dc\65\3\2\2\2\u00dd\u00de\7\24\2\2\u00de\67\3"+
		"\2\2\2\u00df\u00e0\7\17\2\2\u00e0\u00e1\5.\30\2\u00e1\u00e2\7\21\2\2\u00e2"+
		"\u00e7\3\2\2\2\u00e3\u00e7\5<\37\2\u00e4\u00e7\5D#\2\u00e5\u00e7\5B\""+
		"\2\u00e6\u00df\3\2\2\2\u00e6\u00e3\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e5"+
		"\3\2\2\2\u00e79\3\2\2\2\u00e8\u00e9\7\17\2\2\u00e9\u00ea\5\60\31\2\u00ea"+
		"\u00eb\7\21\2\2\u00eb\u00f2\3\2\2\2\u00ec\u00f2\5<\37\2\u00ed\u00f2\5"+
		"D#\2\u00ee\u00f2\5B\"\2\u00ef\u00f0\7\16\2\2\u00f0\u00f2\5B\"\2\u00f1"+
		"\u00e8\3\2\2\2\u00f1\u00ec\3\2\2\2\u00f1\u00ed\3\2\2\2\u00f1\u00ee\3\2"+
		"\2\2\u00f1\u00ef\3\2\2\2\u00f2;\3\2\2\2\u00f3\u00f6\7\f\2\2\u00f4\u00f7"+
		"\5> \2\u00f5\u00f7\5@!\2\u00f6\u00f4\3\2\2\2\u00f6\u00f5\3\2\2\2\u00f7"+
		"=\3\2\2\2\u00f8\u00fb\5F$\2\u00f9\u00fa\7\25\2\2\u00fa\u00fc\5F$\2\u00fb"+
		"\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc?\3\2\2\2\u00fd\u00fe\7\25\2\2"+
		"\u00fe\u00ff\5F$\2\u00ffA\3\2\2\2\u0100\u0101\7\26\2\2\u0101C\3\2\2\2"+
		"\u0102\u0103\7\27\2\2\u0103E\3\2\2\2\u0104\u0105\7\30\2\2\u0105G\3\2\2"+
		"\2\31KQ`gjrz\u0080\u0086\u008a\u0094\u0098\u009c\u00a6\u00ae\u00be\u00c0"+
		"\u00d0\u00d2\u00e6\u00f1\u00f6\u00fb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}