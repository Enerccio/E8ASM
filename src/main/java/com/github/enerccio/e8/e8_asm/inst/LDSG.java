package com.github.enerccio.e8.e8_asm.inst;

import com.github.enerccio.e8.e8_asm.AssemblyException;
import com.github.enerccio.e8.e8_asm.Expression;
import com.github.enerccio.e8.e8_asm.Instruction;

public class LDSG extends Instruction {

	private final Expression e1, e2;
	
	public LDSG(Expression e1, Expression e2) {
		this.e1 = e1;
		this.e2 = e2;
	}
	
	public Expression getRegister() {
		return e1;
	}
	
	public Expression getValue() {
		return e2;
	}

	@Override
	public byte toByte() {
		byte t;
		short e1r = e1.resolve();
		
		if (e1r == 1) {
			t = (byte) 0b10000000;
		} else if (e1r == 2) {
			t = (byte) 0b11000000;
		} else {
			throw new AssemblyException("Segment register number invalid, expected 1, 2, got " + e1r);
		}
		
		return (byte) (t + ((byte) e2.resolve() & 0b00111111));
	}
	
	@Override
	public String toInst() {
		return "LDSG";
	}
	
}
