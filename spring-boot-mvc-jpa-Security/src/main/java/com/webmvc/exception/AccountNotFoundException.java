package com.webmvc.exception;

public class AccountNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1314772352119575850L;

	public AccountNotFoundException(String message) {
		super(message);
	}

	
}
