package com.github.enerccio.e8.e8_asm.expr;

import java.util.ArrayList;
import java.util.List;

import com.github.enerccio.e8.e8_asm.Expression;
import com.github.enerccio.e8.e8_asm.MemoryResolver;

public class MinusExpression extends Expression {
	
	private final Expression l, r;
	
	public MinusExpression(Expression l, Expression r) {
		this.l = l;
		this.r = r;
	}

	@Override
	public short resolve() {
		int ra = l.resolve() - r.resolve();
		return (short) (ra & 0xffffffff);
	}

	@Override
	public List<MemoryResolver> getResolvers() {
		List<MemoryResolver> l = new ArrayList<MemoryResolver>();
		l.addAll(this.l.getResolvers());
		l.addAll(this.r.getResolvers());
		return l;
	}

	
}
