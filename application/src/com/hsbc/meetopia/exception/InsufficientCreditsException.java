package com.hsbc.meetopia.exception;

public class InsufficientCreditsException extends Exception {

	public InsufficientCreditsException(String message) {
		super(message);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

}