package com.github.enerccio.e8.e8_asm.inst;

import com.github.enerccio.e8.e8_asm.Instruction;

public class MATH extends Instruction {
	
	public enum MathOperation {
		
		SL, PLUS, MINUS, AND, OR, XOR, SR, NEG
		
	}
	
	private MathOperation mo;
	
	public static MATH shiftLeft() {
		return new MATH(MathOperation.SL);
	}
	
	public static MATH plus() {
		return new MATH(MathOperation.PLUS);
	}
	
	public static MATH minus() {
		return new MATH(MathOperation.MINUS);
	}
	
	public static MATH and() {
		return new MATH(MathOperation.AND);
	}
	
	public static MATH or() {
		return new MATH(MathOperation.OR);
	}
	
	public static MATH xor() {
		return new MATH(MathOperation.XOR);
	}
	
	public static MATH shiftRight() {
		return new MATH(MathOperation.SR);
	}
	
	public static MATH neg() {
		return new MATH(MathOperation.NEG);
	}
	
	private MATH(MathOperation mo) {
		this.mo = mo;
	}
	
	/*
	000: shift left
	001: plus
	010: minus 
	011: and
	100: or
	101: xor
	110: shift right
	111: neg
	 */

	@Override
	public byte toByte() {
		switch (mo) {
		case SL: return 0b00011000;
		case PLUS: return 0b00011001;
		case MINUS: return 0b0011101;
		case AND: return 0b00011011;
		case OR: return 0b00011100;
		case XOR: return 0b00011101;
		case SR: return 0b00011110;
		case NEG: return 0b00011111;
		}
		return 0x0;
	}	
	
	
	@Override
	public String toInst() {
		switch (mo) {
		case SL: return "SL";
		case PLUS: return "PLUS";
		case MINUS: return "MINUS";
		case AND: return "AND";
		case OR: return "OR";
		case XOR: return "XOR";
		case SR: return "SR";
		case NEG: return "NEG";
		}
		return "MATHINVALID";
	}
}
