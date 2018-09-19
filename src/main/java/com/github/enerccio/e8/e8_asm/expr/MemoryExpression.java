package com.github.enerccio.e8.e8_asm.expr;

import java.util.Arrays;
import java.util.List;

import com.github.enerccio.e8.e8_asm.Expression;
import com.github.enerccio.e8.e8_asm.MemoryResolver;

public class MemoryExpression extends Expression {
	
	private final MemoryResolver mr;
	
	public MemoryExpression(MemoryResolver mr) {
		this.mr = mr;
	}

	@Override
	public short resolve() {
		return mr.getAddress();
	}

	@Override
	public List<MemoryResolver> getResolvers() {
		return Arrays.asList(mr);
	}

}
