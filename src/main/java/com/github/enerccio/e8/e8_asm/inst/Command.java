package com.github.enerccio.e8.e8_asm.inst;

import com.github.enerccio.e8.e8_asm.Instruction;

public class Command extends Instruction {
	
	private byte v;
	
	public Command(byte v) {
		this.v = v;
	}

	@Override
	public byte toByte() {
		return v;
	}
	
	

}
