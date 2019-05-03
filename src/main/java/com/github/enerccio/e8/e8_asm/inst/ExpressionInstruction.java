package com.github.enerccio.e8.e8_asm.inst;

import com.github.enerccio.e8.e8_asm.AssemblyException;
import com.github.enerccio.e8.e8_asm.Expression;
import com.github.enerccio.e8.e8_asm.Instruction;

public abstract class ExpressionInstruction extends Instruction {
	
	private final Expression e;
	
	public ExpressionInstruction(Expression e) {
		this.e = e;
	}

	public byte getExpressionValue() {
		short s = e.resolve();
		if (s < 0 || s > 255)
			throw new AssemblyException("Out of range: " + s);
		return (byte) (s & 0xff);
	}
	
	public byte getTinyValue() {
		byte r = getExpressionValue();
		if (r < 0 || r > 15) {
			throw new AssemblyException("Out of range (0-15): " + r); 
		}
		return r;
	}

}
