package com.github.enerccio.e8.e8_asm.inst;

import com.github.enerccio.e8.e8_asm.Instruction;

public class PUSHSG1 extends Instruction {

	@Override
	public byte toByte() {
		return 0b00010100;
	}	
	
	@Override
	public String toInst() {
		return "PUSHSG1";
	}
	
}
