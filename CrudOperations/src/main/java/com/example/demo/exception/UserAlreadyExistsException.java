package com.example.demo.exception;




public class UserAlreadyExistsException extends RuntimeException {
	private String errorMessage;

	public UserAlreadyExistsException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}
	
}
