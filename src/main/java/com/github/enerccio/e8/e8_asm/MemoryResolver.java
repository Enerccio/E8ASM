package com.github.enerccio.e8.e8_asm;

public class MemoryResolver {
	
	private final String module, label, sublabel;
	private short address;
	
	public MemoryResolver(String module, String label, String sublabel) {
		this.module = module;
		this.label = label;
		this.sublabel = sublabel;
	}

	public String getModule() {
		return module;
	}

	public String getLabel() {
		return label;
	}

	public String getSublabel() {
		return sublabel;
	}

	public short getAddress() {
		return address;
	}

	public void setAddress(short address) {
		this.address = address;
	}
	
}
