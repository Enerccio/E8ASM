package com.github.enerccio.e8.e8_asm;

public class AssemblyException extends RuntimeException {
	private static final long serialVersionUID = 1786300689730561963L;

	public AssemblyException() {
		super();
	}

	public AssemblyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AssemblyException(String message, Throwable cause) {
		super(message, cause);
	}

	public AssemblyException(String message) {
		super(message);
	}

	public AssemblyException(Throwable cause) {
		super(cause);
	}

	
}
