package com.github.enerccio.e8.e8_asm.inst;

import com.github.enerccio.e8.e8_asm.Instruction;

public class POPSG1 extends Instruction {

	@Override
	public byte toByte() {
		return 0b00010101;
	}	
	
	@Override
	public String toInst() {
		return "POPSG1";
	}
}
