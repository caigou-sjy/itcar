package com.sjy.it.user.exception;

/**
 * 用户名或密码错误
 */
public class InvildUserException extends SpringbootException {
	
	public InvildUserException(String message) {
		super(message);
	}
}
