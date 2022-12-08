package com.ty.Bookmanagement.Book_management_boot_prc.exception;

public class UnableToUpdateException extends RuntimeException {

	private String message = "Unable To Update Exception";

	public UnableToUpdateException(String message) {
		super();
		this.message = message;
	}

	public UnableToUpdateException() {

	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

}
