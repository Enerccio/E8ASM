package com.github.enerccio.e8.e8_asm.inst;

import com.github.enerccio.e8.e8_asm.Expression;

public class STORE extends ExpressionInstruction {
	
	public STORE(Expression e) {
		super(e);
	}

	@Override
	public byte toByte() {
		return (byte) (0b00110000 + getTinyValue());
	}	

}
