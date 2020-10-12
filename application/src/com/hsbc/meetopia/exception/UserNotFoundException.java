package com.hsbc.meetopia.exception;

public class UserNotFoundException extends Exception {

	public UserNotFoundException(String message) {
		super(message);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

}