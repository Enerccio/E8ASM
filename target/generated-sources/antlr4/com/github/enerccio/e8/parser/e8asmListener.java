// Generated from com/github/enerccio/e8/parser/e8asm.g4 by ANTLR 4.3
package com.github.enerccio.e8.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link e8asmParser}.
 */
public interface e8asmListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link e8asmParser#blockCommands}.
	 * @param ctx the parse tree
	 */
	void enterBlockCommands(@NotNull e8asmParser.BlockCommandsContext ctx);
	/**
	 * Exit a parse tree produced by {@link e8asmParser#blockCommands}.
	 * @param ctx the parse tree
	 */
	void exitBlockCommands(@NotNull e8asmParser.BlockCommandsContext ctx);

	/**
	 * Enter a parse tree produced by {@link e8asmParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(@NotNull e8asmParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link e8asmParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(@NotNull e8asmParser.ConstantContext ctx);

	/**
	 * Enter a parse tree produced by {@link e8asmParser#memory}.
	 * @param ctx the parse tree
	 */
	void enterMemory(@NotNull e8asmParser.MemoryContext ctx);
	/**
	 * Exit a parse tree produced by {@link e8asmParser#memory}.
	 * @param ctx the parse tree
	 */
	void exitMemory(@NotNull e8asmParser.MemoryContext ctx);

	/**
	 * Enter a parse tree produced by {@link e8asmParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(@NotNull e8asmParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link e8asmParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(@NotNull e8asmParser.StringContext ctx);

	/**
	 * Enter a parse tree produced by {@link e8asmParser#blockName}.
	 * @param ctx the parse tree
	 */
	void enterBlockName(@NotNull e8asmParser.BlockNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link e8asmParser#blockName}.
	 * @param ctx the parse tree
	 */
	void exitBlockName(@NotNull e8asmParser.BlockNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link e8asmParser#compoundIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterCompoundIdentifier(@NotNull e8asmParser.CompoundIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link e8asmParser#compoundIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitCompoundIdentifier(@NotNull e8asmParser.CompoundIdentifierContext ctx);

	/**
	 * Enter a parse tree produced by {@link e8asmParser#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(@NotNull e8asmParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link e8asmParser#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(@NotNull e8asmParser.IntegerContext ctx);

	/**
	 * Enter a parse tree produced by {@link e8asmParser#macroBody}.
	 * @param ctx the parse tree
	 */
	void enterMacroBody(@NotNull e8asmParser.MacroBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link e8asmParser#macroBody}.
	 * @param ctx the parse tree
	 */
	void exitMacroBody(@NotNull e8asmParser.MacroBodyContext ctx);

	/**
	 * Enter a parse tree produced by {@link e8asmParser#minusExpr}.
	 * @param ctx the parse tree
	 */
	void enterMinusExpr(@NotNull e8asmParser.MinusExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link e8asmParser#minusExpr}.
	 * @param ctx the parse tree
	 */
	void exitMinusExpr(@NotNull e8asmParser.MinusExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link e8asmParser#assemblerMacroCommand}.
	 * @param ctx the parse tree
	 */
	void enterAssemblerMacroCommand(@NotNull e8asmParser.AssemblerMacroCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link e8asmParser#assemblerMacroCommand}.
	 * @param ctx the parse tree
	 */
	void exitAssemblerMacroCommand(@NotNull e8asmParser.AssemblerMacroCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link e8asmParser#macroIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterMacroIdentifier(@NotNull e8asmParser.MacroIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link e8asmParser#macroIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitMacroIdentifier(@NotNull e8asmParser.MacroIdentifierContext ctx);

	/**
	 * Enter a parse tree produced by {@link e8asmParser#macroPrimary}.
	 * @param ctx the parse tree
	 */
	void enterMacroPrimary(@NotNull e8asmParser.MacroPrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link e8asmParser#macroPrimary}.
	 * @param ctx the parse tree
	 */
	void exitMacroPrimary(@NotNull e8asmParser.MacroPrimaryContext ctx);

	/**
	 * Enter a parse tree produced by {@link e8asmParser#definition}.
	 * @param ctx the parse tree
	 */
	void enterDefinition(@NotNull e8asmParser.DefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link e8asmParser#definition}.
	 * @param ctx the parse tree
	 */
	void exitDefinition(@NotNull e8asmParser.DefinitionContext ctx);

	/**
	 * Enter a parse tree produced by {@link e8asmParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull e8asmParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link e8asmParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull e8asmParser.BlockContext ctx);

	/**
	 * Enter a parse tree produced by {@link e8asmParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(@NotNull e8asmParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link e8asmParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(@NotNull e8asmParser.ExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link e8asmParser#blockAddress}.
	 * @param ctx the parse tree
	 */
	void enterBlockAddress(@NotNull e8asmParser.BlockAddressContext ctx);
	/**
	 * Exit a parse tree produced by {@link e8asmParser#blockAddress}.
	 * @param ctx the parse tree
	 */
	void exitBlockAddress(@NotNull e8asmParser.BlockAddressContext ctx);

	/**
	 * Enter a parse tree produced by {@link e8asmParser#cmdArgs}.
	 * @param ctx the parse tree
	 */
	void enterCmdArgs(@NotNull e8asmParser.CmdArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link e8asmParser#cmdArgs}.
	 * @param ctx the parse tree
	 */
	void exitCmdArgs(@NotNull e8asmParser.CmdArgsContext ctx);

	/**
	 * Enter a parse tree produced by {@link e8asmParser#addrType}.
	 * @param ctx the parse tree
	 */
	void enterAddrType(@NotNull e8asmParser.AddrTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link e8asmParser#addrType}.
	 * @param ctx the parse tree
	 */
	void exitAddrType(@NotNull e8asmParser.AddrTypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link e8asmParser#macro}.
	 * @param ctx the parse tree
	 */
	void enterMacro(@NotNull e8asmParser.MacroContext ctx);
	/**
	 * Exit a parse tree produced by {@link e8asmParser#macro}.
	 * @param ctx the parse tree
	 */
	void exitMacro(@NotNull e8asmParser.MacroContext ctx);

	/**
	 * Enter a parse tree produced by {@link e8asmParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(@NotNull e8asmParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link e8asmParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(@NotNull e8asmParser.IdentifierContext ctx);

	/**
	 * Enter a parse tree produced by {@link e8asmParser#macroCmdArgs}.
	 * @param ctx the parse tree
	 */
	void enterMacroCmdArgs(@NotNull e8asmParser.MacroCmdArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link e8asmParser#macroCmdArgs}.
	 * @param ctx the parse tree
	 */
	void exitMacroCmdArgs(@NotNull e8asmParser.MacroCmdArgsContext ctx);

	/**
	 * Enter a parse tree produced by {@link e8asmParser#macroExpr}.
	 * @param ctx the parse tree
	 */
	void enterMacroExpr(@NotNull e8asmParser.MacroExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link e8asmParser#macroExpr}.
	 * @param ctx the parse tree
	 */
	void exitMacroExpr(@NotNull e8asmParser.MacroExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link e8asmParser#identifiers}.
	 * @param ctx the parse tree
	 */
	void enterIdentifiers(@NotNull e8asmParser.IdentifiersContext ctx);
	/**
	 * Exit a parse tree produced by {@link e8asmParser#identifiers}.
	 * @param ctx the parse tree
	 */
	void exitIdentifiers(@NotNull e8asmParser.IdentifiersContext ctx);

	/**
	 * Enter a parse tree produced by {@link e8asmParser#label}.
	 * @param ctx the parse tree
	 */
	void enterLabel(@NotNull e8asmParser.LabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link e8asmParser#label}.
	 * @param ctx the parse tree
	 */
	void exitLabel(@NotNull e8asmParser.LabelContext ctx);

	/**
	 * Enter a parse tree produced by {@link e8asmParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(@NotNull e8asmParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link e8asmParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(@NotNull e8asmParser.CommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link e8asmParser#plusExpr}.
	 * @param ctx the parse tree
	 */
	void enterPlusExpr(@NotNull e8asmParser.PlusExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link e8asmParser#plusExpr}.
	 * @param ctx the parse tree
	 */
	void exitPlusExpr(@NotNull e8asmParser.PlusExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link e8asmParser#macroId}.
	 * @param ctx the parse tree
	 */
	void enterMacroId(@NotNull e8asmParser.MacroIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link e8asmParser#macroId}.
	 * @param ctx the parse tree
	 */
	void exitMacroId(@NotNull e8asmParser.MacroIdContext ctx);

	/**
	 * Enter a parse tree produced by {@link e8asmParser#assemblerCommand}.
	 * @param ctx the parse tree
	 */
	void enterAssemblerCommand(@NotNull e8asmParser.AssemblerCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link e8asmParser#assemblerCommand}.
	 * @param ctx the parse tree
	 */
	void exitAssemblerCommand(@NotNull e8asmParser.AssemblerCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link e8asmParser#macroCommand}.
	 * @param ctx the parse tree
	 */
	void enterMacroCommand(@NotNull e8asmParser.MacroCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link e8asmParser#macroCommand}.
	 * @param ctx the parse tree
	 */
	void exitMacroCommand(@NotNull e8asmParser.MacroCommandContext ctx);

	/**
	 * Enter a parse tree produced by {@link e8asmParser#paramCount}.
	 * @param ctx the parse tree
	 */
	void enterParamCount(@NotNull e8asmParser.ParamCountContext ctx);
	/**
	 * Exit a parse tree produced by {@link e8asmParser#paramCount}.
	 * @param ctx the parse tree
	 */
	void exitParamCount(@NotNull e8asmParser.ParamCountContext ctx);

	/**
	 * Enter a parse tree produced by {@link e8asmParser#bitPart}.
	 * @param ctx the parse tree
	 */
	void enterBitPart(@NotNull e8asmParser.BitPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link e8asmParser#bitPart}.
	 * @param ctx the parse tree
	 */
	void exitBitPart(@NotNull e8asmParser.BitPartContext ctx);

	/**
	 * Enter a parse tree produced by {@link e8asmParser#localIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterLocalIdentifier(@NotNull e8asmParser.LocalIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link e8asmParser#localIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitLocalIdentifier(@NotNull e8asmParser.LocalIdentifierContext ctx);

	/**
	 * Enter a parse tree produced by {@link e8asmParser#asmUnit}.
	 * @param ctx the parse tree
	 */
	void enterAsmUnit(@NotNull e8asmParser.AsmUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link e8asmParser#asmUnit}.
	 * @param ctx the parse tree
	 */
	void exitAsmUnit(@NotNull e8asmParser.AsmUnitContext ctx);

	/**
	 * Enter a parse tree produced by {@link e8asmParser#macroConstant}.
	 * @param ctx the parse tree
	 */
	void enterMacroConstant(@NotNull e8asmParser.MacroConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link e8asmParser#macroConstant}.
	 * @param ctx the parse tree
	 */
	void exitMacroConstant(@NotNull e8asmParser.MacroConstantContext ctx);

	/**
	 * Enter a parse tree produced by {@link e8asmParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(@NotNull e8asmParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link e8asmParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(@NotNull e8asmParser.PrimaryContext ctx);
}