package com.github.enerccio.e8.e8_asm.inst;

import com.github.enerccio.e8.e8_asm.Expression;

public class SJMPZ extends ExpressionInstruction {

	public SJMPZ(Expression e) {
		super(e);
	}

	@Override
	public byte toByte() {
		return (byte) (0b01110000 + getTinyValue());
	}
	
	
}
