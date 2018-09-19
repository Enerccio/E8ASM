package com.github.enerccio.e8.e8_asm.inst;

import com.github.enerccio.e8.e8_asm.Expression;

public class LOAD extends ExpressionInstruction {
	
	public LOAD(Expression e) {
		super(e);
	}

	@Override
	public byte toByte() {
		return (byte) (0b00100000 + getTinyValue());
	}	

}
