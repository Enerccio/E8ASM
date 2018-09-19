// Generated from com/github/enerccio/e8/parser/e8asm.g4 by ANTLR 4.3
package com.github.enerccio.e8.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class e8asmLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__18=1, T__17=2, T__16=3, T__15=4, T__14=5, T__13=6, T__12=7, T__11=8, 
		T__10=9, T__9=10, T__8=11, T__7=12, T__6=13, T__5=14, T__4=15, T__3=16, 
		T__2=17, T__1=18, T__0=19, IntegerLiteral=20, StringLiteral=21, Identifier=22, 
		WS=23, COMMENT=24, LINE_COMMENT=25;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'"
	};
	public static final String[] ruleNames = {
		"T__18", "T__17", "T__16", "T__15", "T__14", "T__13", "T__12", "T__11", 
		"T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", 
		"T__1", "T__0", "IntegerLiteral", "DecimalIntegerLiteral", "HexIntegerLiteral", 
		"OctalIntegerLiteral", "BinaryIntegerLiteral", "DecimalNumeral", "Digits", 
		"Digit", "NonZeroDigit", "DigitOrUnderscore", "Underscores", "HexNumeral", 
		"HexDigits", "HexDigit", "HexDigitOrUnderscore", "OctalNumeral", "OctalDigits", 
		"OctalDigit", "OctalDigitOrUnderscore", "BinaryNumeral", "BinaryDigits", 
		"BinaryDigit", "BinaryDigitOrUnderscore", "StringLiteral", "StringCharacters", 
		"StringCharacter", "EscapeSequence", "OctalEscape", "ZeroToThree", "Identifier", 
		"Letter", "LetterOrDigit", "WS", "COMMENT", "LINE_COMMENT"
	};


	public e8asmLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "e8asm.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 49: return Letter_sempred((RuleContext)_localctx, predIndex);

		case 50: return LetterOrDigit_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean Letter_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return Character.isJavaIdentifierStart(_input.LA(-1));

		case 1: return Character.isJavaIdentifierStart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)));
		}
		return true;
	}
	private boolean LetterOrDigit_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2: return Character.isJavaIdentifierPart(_input.LA(-1));

		case 3: return Character.isJavaIdentifierPart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)));
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\33\u0185\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6"+
		"\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3"+
		"\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23"+
		"\3\24\3\24\3\25\3\25\3\25\3\25\5\25\u00bf\n\25\3\26\3\26\3\27\3\27\3\30"+
		"\3\30\3\31\3\31\3\32\3\32\3\32\5\32\u00cc\n\32\3\32\3\32\3\32\5\32\u00d1"+
		"\n\32\5\32\u00d3\n\32\3\33\3\33\7\33\u00d7\n\33\f\33\16\33\u00da\13\33"+
		"\3\33\5\33\u00dd\n\33\3\34\3\34\5\34\u00e1\n\34\3\35\3\35\3\36\3\36\5"+
		"\36\u00e7\n\36\3\37\6\37\u00ea\n\37\r\37\16\37\u00eb\3 \3 \3 \3 \3!\3"+
		"!\7!\u00f4\n!\f!\16!\u00f7\13!\3!\5!\u00fa\n!\3\"\3\"\3#\3#\5#\u0100\n"+
		"#\3$\3$\5$\u0104\n$\3$\3$\3%\3%\7%\u010a\n%\f%\16%\u010d\13%\3%\5%\u0110"+
		"\n%\3&\3&\3\'\3\'\5\'\u0116\n\'\3(\3(\3(\3(\3)\3)\7)\u011e\n)\f)\16)\u0121"+
		"\13)\3)\5)\u0124\n)\3*\3*\3+\3+\5+\u012a\n+\3,\3,\5,\u012e\n,\3,\3,\3"+
		"-\6-\u0133\n-\r-\16-\u0134\3.\3.\5.\u0139\n.\3/\3/\3/\5/\u013e\n/\3\60"+
		"\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\5\60\u014b\n\60\3\61"+
		"\3\61\3\62\3\62\7\62\u0151\n\62\f\62\16\62\u0154\13\62\3\63\3\63\3\63"+
		"\3\63\3\63\3\63\5\63\u015c\n\63\3\64\3\64\3\64\3\64\3\64\3\64\5\64\u0164"+
		"\n\64\3\65\6\65\u0167\n\65\r\65\16\65\u0168\3\65\3\65\3\66\3\66\3\66\3"+
		"\66\7\66\u0171\n\66\f\66\16\66\u0174\13\66\3\66\3\66\3\66\3\66\3\66\3"+
		"\67\3\67\3\67\3\67\7\67\u017f\n\67\f\67\16\67\u0182\13\67\3\67\3\67\3"+
		"\u0172\28\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\2-\2/\2\61\2\63\2\65\2\67\29\2;"+
		"\2=\2?\2A\2C\2E\2G\2I\2K\2M\2O\2Q\2S\2U\2W\27Y\2[\2]\2_\2a\2c\30e\2g\2"+
		"i\31k\32m\33\3\2\22\3\2\63;\4\2ZZzz\5\2\62;CHch\3\2\629\4\2DDdd\3\2\62"+
		"\63\4\2$$^^\n\2$$))^^ddhhppttvv\3\2\62\65\5\2C\\aac|\4\2\2\u0081\ud802"+
		"\udc01\3\2\ud802\udc01\3\2\udc02\ue001\6\2\62;C\\aac|\5\2\13\f\16\17\""+
		"\"\4\2\f\f\17\17\u018a\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2W\3\2\2"+
		"\2\2c\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\3o\3\2\2\2\5v\3\2\2\2\7"+
		"~\3\2\2\2\t\u0080\3\2\2\2\13\u0088\3\2\2\2\r\u008a\3\2\2\2\17\u008c\3"+
		"\2\2\2\21\u008e\3\2\2\2\23\u0097\3\2\2\2\25\u009b\3\2\2\2\27\u009d\3\2"+
		"\2\2\31\u00a3\3\2\2\2\33\u00a5\3\2\2\2\35\u00a7\3\2\2\2\37\u00b0\3\2\2"+
		"\2!\u00b2\3\2\2\2#\u00b4\3\2\2\2%\u00b6\3\2\2\2\'\u00b8\3\2\2\2)\u00be"+
		"\3\2\2\2+\u00c0\3\2\2\2-\u00c2\3\2\2\2/\u00c4\3\2\2\2\61\u00c6\3\2\2\2"+
		"\63\u00d2\3\2\2\2\65\u00d4\3\2\2\2\67\u00e0\3\2\2\29\u00e2\3\2\2\2;\u00e6"+
		"\3\2\2\2=\u00e9\3\2\2\2?\u00ed\3\2\2\2A\u00f1\3\2\2\2C\u00fb\3\2\2\2E"+
		"\u00ff\3\2\2\2G\u0101\3\2\2\2I\u0107\3\2\2\2K\u0111\3\2\2\2M\u0115\3\2"+
		"\2\2O\u0117\3\2\2\2Q\u011b\3\2\2\2S\u0125\3\2\2\2U\u0129\3\2\2\2W\u012b"+
		"\3\2\2\2Y\u0132\3\2\2\2[\u0138\3\2\2\2]\u013d\3\2\2\2_\u014a\3\2\2\2a"+
		"\u014c\3\2\2\2c\u014e\3\2\2\2e\u015b\3\2\2\2g\u0163\3\2\2\2i\u0166\3\2"+
		"\2\2k\u016c\3\2\2\2m\u017a\3\2\2\2op\7U\2\2pq\7[\2\2qr\7U\2\2rs\7V\2\2"+
		"st\7G\2\2tu\7O\2\2u\4\3\2\2\2vw\7U\2\2wx\7G\2\2xy\7E\2\2yz\7V\2\2z{\7"+
		"K\2\2{|\7Q\2\2|}\7P\2\2}\6\3\2\2\2~\177\7<\2\2\177\b\3\2\2\2\u0080\u0081"+
		"\7C\2\2\u0081\u0082\7F\2\2\u0082\u0083\7F\2\2\u0083\u0084\7T\2\2\u0084"+
		"\u0085\7G\2\2\u0085\u0086\7U\2\2\u0086\u0087\7U\2\2\u0087\n\3\2\2\2\u0088"+
		"\u0089\7]\2\2\u0089\f\3\2\2\2\u008a\u008b\7=\2\2\u008b\16\3\2\2\2\u008c"+
		"\u008d\7_\2\2\u008d\20\3\2\2\2\u008e\u008f\7G\2\2\u008f\u0090\7P\2\2\u0090"+
		"\u0091\7F\2\2\u0091\u0092\7O\2\2\u0092\u0093\7C\2\2\u0093\u0094\7E\2\2"+
		"\u0094\u0095\7T\2\2\u0095\u0096\7Q\2\2\u0096\22\3\2\2\2\u0097\u0098\7"+
		"F\2\2\u0098\u0099\7F\2\2\u0099\u009a\7F\2\2\u009a\24\3\2\2\2\u009b\u009c"+
		"\7&\2\2\u009c\26\3\2\2\2\u009d\u009e\7O\2\2\u009e\u009f\7C\2\2\u009f\u00a0"+
		"\7E\2\2\u00a0\u00a1\7T\2\2\u00a1\u00a2\7Q\2\2\u00a2\30\3\2\2\2\u00a3\u00a4"+
		"\7(\2\2\u00a4\32\3\2\2\2\u00a5\u00a6\7*\2\2\u00a6\34\3\2\2\2\u00a7\u00a8"+
		"\7C\2\2\u00a8\u00a9\7P\2\2\u00a9\u00aa\7[\2\2\u00aa\u00ab\7Y\2\2\u00ab"+
		"\u00ac\7J\2\2\u00ac\u00ad\7G\2\2\u00ad\u00ae\7T\2\2\u00ae\u00af\7G\2\2"+
		"\u00af\36\3\2\2\2\u00b0\u00b1\7+\2\2\u00b1 \3\2\2\2\u00b2\u00b3\7-\2\2"+
		"\u00b3\"\3\2\2\2\u00b4\u00b5\7.\2\2\u00b5$\3\2\2\2\u00b6\u00b7\7/\2\2"+
		"\u00b7&\3\2\2\2\u00b8\u00b9\7\60\2\2\u00b9(\3\2\2\2\u00ba\u00bf\5+\26"+
		"\2\u00bb\u00bf\5-\27\2\u00bc\u00bf\5/\30\2\u00bd\u00bf\5\61\31\2\u00be"+
		"\u00ba\3\2\2\2\u00be\u00bb\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bd\3\2"+
		"\2\2\u00bf*\3\2\2\2\u00c0\u00c1\5\63\32\2\u00c1,\3\2\2\2\u00c2\u00c3\5"+
		"? \2\u00c3.\3\2\2\2\u00c4\u00c5\5G$\2\u00c5\60\3\2\2\2\u00c6\u00c7\5O"+
		"(\2\u00c7\62\3\2\2\2\u00c8\u00d3\7\62\2\2\u00c9\u00d0\59\35\2\u00ca\u00cc"+
		"\5\65\33\2\u00cb\u00ca\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00d1\3\2\2\2"+
		"\u00cd\u00ce\5=\37\2\u00ce\u00cf\5\65\33\2\u00cf\u00d1\3\2\2\2\u00d0\u00cb"+
		"\3\2\2\2\u00d0\u00cd\3\2\2\2\u00d1\u00d3\3\2\2\2\u00d2\u00c8\3\2\2\2\u00d2"+
		"\u00c9\3\2\2\2\u00d3\64\3\2\2\2\u00d4\u00dc\5\67\34\2\u00d5\u00d7\5;\36"+
		"\2\u00d6\u00d5\3\2\2\2\u00d7\u00da\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9"+
		"\3\2\2\2\u00d9\u00db\3\2\2\2\u00da\u00d8\3\2\2\2\u00db\u00dd\5\67\34\2"+
		"\u00dc\u00d8\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\66\3\2\2\2\u00de\u00e1"+
		"\7\62\2\2\u00df\u00e1\59\35\2\u00e0\u00de\3\2\2\2\u00e0\u00df\3\2\2\2"+
		"\u00e18\3\2\2\2\u00e2\u00e3\t\2\2\2\u00e3:\3\2\2\2\u00e4\u00e7\5\67\34"+
		"\2\u00e5\u00e7\7a\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e5\3\2\2\2\u00e7<\3"+
		"\2\2\2\u00e8\u00ea\7a\2\2\u00e9\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb"+
		"\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec>\3\2\2\2\u00ed\u00ee\7\62\2\2"+
		"\u00ee\u00ef\t\3\2\2\u00ef\u00f0\5A!\2\u00f0@\3\2\2\2\u00f1\u00f9\5C\""+
		"\2\u00f2\u00f4\5E#\2\u00f3\u00f2\3\2\2\2\u00f4\u00f7\3\2\2\2\u00f5\u00f3"+
		"\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f8\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8"+
		"\u00fa\5C\"\2\u00f9\u00f5\3\2\2\2\u00f9\u00fa\3\2\2\2\u00faB\3\2\2\2\u00fb"+
		"\u00fc\t\4\2\2\u00fcD\3\2\2\2\u00fd\u0100\5C\"\2\u00fe\u0100\7a\2\2\u00ff"+
		"\u00fd\3\2\2\2\u00ff\u00fe\3\2\2\2\u0100F\3\2\2\2\u0101\u0103\7\62\2\2"+
		"\u0102\u0104\5=\37\2\u0103\u0102\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0105"+
		"\3\2\2\2\u0105\u0106\5I%\2\u0106H\3\2\2\2\u0107\u010f\5K&\2\u0108\u010a"+
		"\5M\'\2\u0109\u0108\3\2\2\2\u010a\u010d\3\2\2\2\u010b\u0109\3\2\2\2\u010b"+
		"\u010c\3\2\2\2\u010c\u010e\3\2\2\2\u010d\u010b\3\2\2\2\u010e\u0110\5K"+
		"&\2\u010f\u010b\3\2\2\2\u010f\u0110\3\2\2\2\u0110J\3\2\2\2\u0111\u0112"+
		"\t\5\2\2\u0112L\3\2\2\2\u0113\u0116\5K&\2\u0114\u0116\7a\2\2\u0115\u0113"+
		"\3\2\2\2\u0115\u0114\3\2\2\2\u0116N\3\2\2\2\u0117\u0118\7\62\2\2\u0118"+
		"\u0119\t\6\2\2\u0119\u011a\5Q)\2\u011aP\3\2\2\2\u011b\u0123\5S*\2\u011c"+
		"\u011e\5U+\2\u011d\u011c\3\2\2\2\u011e\u0121\3\2\2\2\u011f\u011d\3\2\2"+
		"\2\u011f\u0120\3\2\2\2\u0120\u0122\3\2\2\2\u0121\u011f\3\2\2\2\u0122\u0124"+
		"\5S*\2\u0123\u011f\3\2\2\2\u0123\u0124\3\2\2\2\u0124R\3\2\2\2\u0125\u0126"+
		"\t\7\2\2\u0126T\3\2\2\2\u0127\u012a\5S*\2\u0128\u012a\7a\2\2\u0129\u0127"+
		"\3\2\2\2\u0129\u0128\3\2\2\2\u012aV\3\2\2\2\u012b\u012d\7$\2\2\u012c\u012e"+
		"\5Y-\2\u012d\u012c\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u012f\3\2\2\2\u012f"+
		"\u0130\7$\2\2\u0130X\3\2\2\2\u0131\u0133\5[.\2\u0132\u0131\3\2\2\2\u0133"+
		"\u0134\3\2\2\2\u0134\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135Z\3\2\2\2"+
		"\u0136\u0139\n\b\2\2\u0137\u0139\5]/\2\u0138\u0136\3\2\2\2\u0138\u0137"+
		"\3\2\2\2\u0139\\\3\2\2\2\u013a\u013b\7^\2\2\u013b\u013e\t\t\2\2\u013c"+
		"\u013e\5_\60\2\u013d\u013a\3\2\2\2\u013d\u013c\3\2\2\2\u013e^\3\2\2\2"+
		"\u013f\u0140\7^\2\2\u0140\u014b\5K&\2\u0141\u0142\7^\2\2\u0142\u0143\5"+
		"K&\2\u0143\u0144\5K&\2\u0144\u014b\3\2\2\2\u0145\u0146\7^\2\2\u0146\u0147"+
		"\5a\61\2\u0147\u0148\5K&\2\u0148\u0149\5K&\2\u0149\u014b\3\2\2\2\u014a"+
		"\u013f\3\2\2\2\u014a\u0141\3\2\2\2\u014a\u0145\3\2\2\2\u014b`\3\2\2\2"+
		"\u014c\u014d\t\n\2\2\u014db\3\2\2\2\u014e\u0152\5e\63\2\u014f\u0151\5"+
		"g\64\2\u0150\u014f\3\2\2\2\u0151\u0154\3\2\2\2\u0152\u0150\3\2\2\2\u0152"+
		"\u0153\3\2\2\2\u0153d\3\2\2\2\u0154\u0152\3\2\2\2\u0155\u015c\t\13\2\2"+
		"\u0156\u0157\n\f\2\2\u0157\u015c\6\63\2\2\u0158\u0159\t\r\2\2\u0159\u015a"+
		"\t\16\2\2\u015a\u015c\6\63\3\2\u015b\u0155\3\2\2\2\u015b\u0156\3\2\2\2"+
		"\u015b\u0158\3\2\2\2\u015cf\3\2\2\2\u015d\u0164\t\17\2\2\u015e\u015f\n"+
		"\f\2\2\u015f\u0164\6\64\4\2\u0160\u0161\t\r\2\2\u0161\u0162\t\16\2\2\u0162"+
		"\u0164\6\64\5\2\u0163\u015d\3\2\2\2\u0163\u015e\3\2\2\2\u0163\u0160\3"+
		"\2\2\2\u0164h\3\2\2\2\u0165\u0167\t\20\2\2\u0166\u0165\3\2\2\2\u0167\u0168"+
		"\3\2\2\2\u0168\u0166\3\2\2\2\u0168\u0169\3\2\2\2\u0169\u016a\3\2\2\2\u016a"+
		"\u016b\b\65\2\2\u016bj\3\2\2\2\u016c\u016d\7\61\2\2\u016d\u016e\7,\2\2"+
		"\u016e\u0172\3\2\2\2\u016f\u0171\13\2\2\2\u0170\u016f\3\2\2\2\u0171\u0174"+
		"\3\2\2\2\u0172\u0173\3\2\2\2\u0172\u0170\3\2\2\2\u0173\u0175\3\2\2\2\u0174"+
		"\u0172\3\2\2\2\u0175\u0176\7,\2\2\u0176\u0177\7\61\2\2\u0177\u0178\3\2"+
		"\2\2\u0178\u0179\b\66\2\2\u0179l\3\2\2\2\u017a\u017b\7\61\2\2\u017b\u017c"+
		"\7\61\2\2\u017c\u0180\3\2\2\2\u017d\u017f\n\21\2\2\u017e\u017d\3\2\2\2"+
		"\u017f\u0182\3\2\2\2\u0180\u017e\3\2\2\2\u0180\u0181\3\2\2\2\u0181\u0183"+
		"\3\2\2\2\u0182\u0180\3\2\2\2\u0183\u0184\b\67\2\2\u0184n\3\2\2\2!\2\u00be"+
		"\u00cb\u00d0\u00d2\u00d8\u00dc\u00e0\u00e6\u00eb\u00f5\u00f9\u00ff\u0103"+
		"\u010b\u010f\u0115\u011f\u0123\u0129\u012d\u0134\u0138\u013d\u014a\u0152"+
		"\u015b\u0163\u0168\u0172\u0180\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}