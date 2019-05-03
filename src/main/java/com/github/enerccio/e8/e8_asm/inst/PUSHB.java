package com.github.enerccio.e8.e8_asm.inst;

import com.github.enerccio.e8.e8_asm.Instruction;

public class PUSHB extends Instruction {

	@Override
	public byte toByte() {
		return 0b00010010;
	}	
	
	@Override
	public String toInst() {
		return "PUSHB";
	}
	
}
