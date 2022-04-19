package com.sjy.it.common.exception;

/**
 * 账号不存在
 */
public class AccountNotFoundException extends SpringbootException {

	public AccountNotFoundException(String message) {
		super(message);
	}
}
