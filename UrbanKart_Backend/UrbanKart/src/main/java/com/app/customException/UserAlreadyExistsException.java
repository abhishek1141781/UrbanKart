package com.app.customException;

@SuppressWarnings("serial")
public class UserAlreadyExistsException extends RuntimeException {
	public UserAlreadyExistsException(String mesg) {
		super(mesg);
	}
}
