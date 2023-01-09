package com.ty.Bookmanagement.Book_management_boot_prc.exception;

public class InvalidCredentialsException extends RuntimeException {
	private String message = "Invalid Credentials...!!!  please enter valid credentials";

	public InvalidCredentialsException(String message) {
		super();
		this.message = message;
	}

	public InvalidCredentialsException() {
	}

	@Override
	public String getMessage() {

		return message;
	}

}
