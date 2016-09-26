package com.vitalii.docks.exceptions;

public class IllegalCapacityException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public IllegalCapacityException() {}

	public IllegalCapacityException(String message) {
		super(message);
	}

	public IllegalCapacityException(Throwable cause) {
		super(cause);
	}

	public IllegalCapacityException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
