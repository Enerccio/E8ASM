package com.github.enerccio.e8.e8_asm.expr;

import com.github.enerccio.e8.e8_asm.Expression;

public class ConstantExpression extends Expression {
	
	private short constant;
	
	public ConstantExpression(short constant) {
		this.constant = constant;
	}

	@Override
	public short resolve() {
		return constant;
	}

}
