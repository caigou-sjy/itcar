package com.sjy.it.common.exception;

/**
 * 用户名不能为空
 */
public class AccountCanNotNoneException extends SpringbootException{
	
	public AccountCanNotNoneException(String message) {
		super(message);
	}

}
