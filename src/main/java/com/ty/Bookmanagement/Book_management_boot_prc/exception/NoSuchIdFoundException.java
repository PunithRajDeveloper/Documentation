package com.ty.Bookmanagement.Book_management_boot_prc.exception;

public class NoSuchIdFoundException extends RuntimeException {
	private String message = "No Such Id Found Exception";

	public NoSuchIdFoundException(String message) {
		super();
		this.message = message;
	}

	public NoSuchIdFoundException() {

	}

	@Override
	public String getMessage() {

		return message;
	}

}
