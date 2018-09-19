package com.github.enerccio.e8.e8_asm.inst;

import com.github.enerccio.e8.e8_asm.Expression;

public class LCONST extends ExpressionInstruction {
	
	public LCONST(Expression e) {
		super(e);
	}

	@Override
	public byte toByte() {
		return (byte) (0b01000000 + getTinyValue());
	}	

}
