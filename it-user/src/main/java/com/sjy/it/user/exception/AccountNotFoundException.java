package com.sjy.it.user.exception;

public class AccountNotFoundException extends SpringbootException {

	public AccountNotFoundException(String message) {
		super(message);
	}
}
