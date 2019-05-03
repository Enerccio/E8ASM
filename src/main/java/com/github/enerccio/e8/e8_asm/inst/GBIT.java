package com.github.enerccio.e8.e8_asm.inst;

import com.github.enerccio.e8.e8_asm.AssemblyException;
import com.github.enerccio.e8.e8_asm.Expression;

public class GBIT extends ExpressionInstruction {
	
	public GBIT(Expression e) {
		super(e);
	}

	@Override
	public byte toByte() {
		return (byte) (0b01011000 + getTinyValue());
	}	
	
	@Override
	public byte getTinyValue() {
		byte r = getExpressionValue();
		if (r < 0 || r > 7) {
			throw new AssemblyException("Out of range (0-7): " + r); 
		}
		return r;
	}
	
	@Override
	public String toInst() {
		return "GBIT";
	}

}
