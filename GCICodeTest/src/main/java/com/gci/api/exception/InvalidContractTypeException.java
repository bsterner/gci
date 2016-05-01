package com.gci.api.exception;

public class InvalidContractTypeException extends RuntimeException {

	private static final long serialVersionUID = 7921503846049217973L;

	public InvalidContractTypeException(String message, Object... args) {
		super(String.format(message, args));
	}

}
