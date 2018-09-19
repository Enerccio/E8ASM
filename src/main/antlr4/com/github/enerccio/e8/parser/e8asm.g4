grammar e8asm;

asmUnit:
	definition+ EOF
	;
	
definition:
	block | macro
	;

macro:
	'MACRO' identifier paramCount
	macroBody
	'ENDMACRO'
	;
	
paramCount:
	integer
	;
	
macroBody:
	(assemblerMacroCommand ';')*
	;
	
block:
	blockName
	blockCommands+
	;
	
blockCommands:
	(label? assemblerCommand ';')
	;
	
blockName:
	'SECTION' identifier
	blockAddress?
	;
	
blockAddress:
	('ADDRESS' addrType)
	;
	
addrType:
	(integer | 'ANYWHERE' | 'SYSTEM')
	;
	
label:
	compoundIdentifier ':' 
	;
	
compoundIdentifier:
	'.' ? identifier
	;

assemblerCommand:
	constant | command
	;
	
assemblerMacroCommand:
	macroConstant | macroCommand
	;
	
constant:
	'DDD' expr
	;
	
macroConstant:
	'DDD' macroExpr
	;
	
command:
	identifier cmdArgs?
	;
	
macroCommand:
	macroIdentifier macroCmdArgs?
	;
	
macroIdentifier:
	identifier | macroId
	;
	
macroId:
	'&' integer
	;
	
cmdArgs:
	expr (',' expr)*
	;
	
macroCmdArgs:
	macroExpr (',' macroExpr)*
	;
	
expr:
	primary
	| expr plusExpr expr
	| expr minusExpr expr
	| expr bitPart
	;
	
macroExpr:
	macroPrimary
	| macroExpr plusExpr macroExpr
	| macroExpr minusExpr macroExpr
	| macroExpr bitPart
	;
	
bitPart:
	'[' integer ':' integer ']'
	;
	
plusExpr:
	'+'
	;

minusExpr:
	'-'
	;
	
primary: 
	'(' expr ')'
	| memory
	| string
	| integer
	;
	
macroPrimary:
	'(' macroExpr ')'
	| memory
	| string
	| integer
	| '&' integer
	;
	
memory:
	'$' (identifiers | localIdentifier)
	;
	
identifiers:
	identifier ('.' identifier)?
	;	
	
localIdentifier:
	'.' identifier
	;

integer:
	IntegerLiteral
	;
	
string:
	StringLiteral
	;	
	
identifier:
	Identifier
	;
	
IntegerLiteral:   
	DecimalIntegerLiteral
    |   HexIntegerLiteral
    |   OctalIntegerLiteral
    |   BinaryIntegerLiteral
    ;

fragment DecimalIntegerLiteral:   
	DecimalNumeral
    ;

fragment HexIntegerLiteral:   
	HexNumeral
    ;

fragment OctalIntegerLiteral:   
	OctalNumeral
    ;

fragment BinaryIntegerLiteral:   
	BinaryNumeral
    ;

fragment DecimalNumeral:   
	'0'
    |   NonZeroDigit (Digits? | Underscores Digits)
    ;

fragment Digits:
    Digit (DigitOrUnderscore* Digit)?
    ;

fragment Digit:   
	'0'
    |   NonZeroDigit
    ;

fragment NonZeroDigit:   
	[1-9]
    ;

fragment DigitOrUnderscore:  
	Digit
    |   '_'
    ;

fragment Underscores:   
	'_'+
    ;

fragment HexNumeral:
    '0' [xX] HexDigits
    ;

fragment HexDigits:  
	HexDigit (HexDigitOrUnderscore* HexDigit)?
    ;

fragment HexDigit:   
	[0-9a-fA-F]
    ;

fragment HexDigitOrUnderscore:   
	HexDigit
    |   '_'
    ;

fragment OctalNumeral:   
	'0' Underscores? OctalDigits
    ;

fragment OctalDigits:
    OctalDigit (OctalDigitOrUnderscore* OctalDigit)?
    ;

fragment OctalDigit:
    [0-7]
    ;

fragment OctalDigitOrUnderscore:
    OctalDigit
    |   '_'
    ;

fragment BinaryNumeral:   
	'0' [bB] BinaryDigits
    ;

fragment BinaryDigits:
    BinaryDigit (BinaryDigitOrUnderscore* BinaryDigit)?
    ;

fragment BinaryDigit:
    [01]
    ;

fragment BinaryDigitOrUnderscore:
    BinaryDigit
    |   '_'
    ;

StringLiteral:
	'"' StringCharacters? '"'
    ;    
    
fragment StringCharacters:
	StringCharacter+
    ;
    
fragment StringCharacter:
    ~["\\]
    |   EscapeSequence
    ;
    
fragment EscapeSequence:
    '\\' [btnfr"'\\]
    |   OctalEscape
    ;

fragment OctalEscape:
    '\\' OctalDigit
    |   '\\' OctalDigit OctalDigit
    |   '\\' ZeroToThree OctalDigit OctalDigit
    ;

fragment ZeroToThree:
    [0-3]
	;
	
Identifier:   
	Letter LetterOrDigit*
    ;

fragment Letter:
    [a-zA-Z_] // these are the "java letters" below 0x7F
    |   ~[\u0000-\u007F\uD800-\uDBFF]
        {Character.isJavaIdentifierStart(_input.LA(-1))}?
    |   [\uD800-\uDBFF] [\uDC00-\uDFFF]
        {Character.isJavaIdentifierStart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)))}?
    ;

fragment LetterOrDigit:   
	[a-zA-Z0-9_] 
    |   ~[\u0000-\u007F\uD800-\uDBFF]
        {Character.isJavaIdentifierPart(_input.LA(-1))}?
    |   [\uD800-\uDBFF] [\uDC00-\uDFFF]
        {Character.isJavaIdentifierPart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)))}?
    ;

WS:  
	[ \r\n\t\u000C]+ -> skip
    ;

COMMENT:
    '/*' .*? '*/' -> skip
    ;

LINE_COMMENT:
    '//' ~[\r\n]* -> skip
	;