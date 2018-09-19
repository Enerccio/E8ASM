package com.github.enerccio.e8.e8_asm;

import java.util.Arrays;
import java.util.List;

public abstract class Expression {
	
	public abstract short resolve();
	
	public List<MemoryResolver> getResolvers() {
		return Arrays.asList();
	}

}
