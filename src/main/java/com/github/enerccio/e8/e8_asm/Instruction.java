package com.github.enerccio.e8.e8_asm;

public abstract class Instruction {
	
	public byte toByte() {
		return 0;
	}
	
	public abstract String toInst();

}
