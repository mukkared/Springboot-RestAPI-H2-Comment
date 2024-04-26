package com.navin.exception;

public class commentNotFoundException extends RuntimeException {
	
	private	static final long serialVersionUID = 1L;

	public commentNotFoundException(String message) {
		super(message);
	}

	public commentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
