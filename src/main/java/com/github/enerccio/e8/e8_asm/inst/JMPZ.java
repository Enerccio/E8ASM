package com.github.enerccio.e8.e8_asm.inst;

import com.github.enerccio.e8.e8_asm.Expression;

public class JMPZ extends ExpressionInstruction {

	public JMPZ(Expression e) {
		super(e);
	}

	@Override
	public byte toByte() {
		return (byte) (0b01100000 + getTinyValue());
	}
	
	@Override
	public String toInst() {
		return "JMPZ";
	}
	
}
