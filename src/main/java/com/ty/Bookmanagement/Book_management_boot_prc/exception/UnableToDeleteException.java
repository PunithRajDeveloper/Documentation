package com.ty.Bookmanagement.Book_management_boot_prc.exception;

public class UnableToDeleteException extends RuntimeException {
	private String message = "UnableToDeleteException";

	public UnableToDeleteException(String message) {
		super();
		this.message = message;
	}

	public UnableToDeleteException() {

	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

}
