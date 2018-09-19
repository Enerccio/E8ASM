package com.github.enerccio.e8.e8_asm.expr;

import java.util.List;

import com.github.enerccio.e8.e8_asm.Expression;
import com.github.enerccio.e8.e8_asm.MemoryResolver;

public class BitPartExpression extends Expression {
	
	private final Expression inner;
	private final byte bitsStart, bitsEnd;
	
	public BitPartExpression(Expression inner, byte bitsStart, byte bitsEnd) {
		this.inner = inner;
		this.bitsStart = bitsStart;
		this.bitsEnd = bitsEnd;
	}

	@Override
	public short resolve() {
		int res = inner.resolve();
		res = (res >> bitsStart);
		res = res & getBitMask((byte) (bitsEnd - 1));
		return (short) ((short) res & 0xffff);
	}

	private int getBitMask(byte b) {
		return ((1 << (b + 1) ) - 1);
	}

	@Override
	public List<MemoryResolver> getResolvers() {
		return inner.getResolvers();
	}

	
}
