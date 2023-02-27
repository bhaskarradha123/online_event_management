package com.ty.online_event_management_web_app.exception;

public class NoSuchElementFoundByMenuServiceException extends RuntimeException {
	private String message = "Id is not Found ";

	public String getMessage() {
		return message;
	}

	public NoSuchElementFoundByMenuServiceException(String message) {
		super();
		this.message = message;
	}

	public NoSuchElementFoundByMenuServiceException() {
		super();

	}

}