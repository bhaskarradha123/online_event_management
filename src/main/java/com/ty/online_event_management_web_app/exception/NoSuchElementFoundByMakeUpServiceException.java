package com.ty.online_event_management_web_app.exception;

public class NoSuchElementFoundByMakeUpServiceException extends RuntimeException {
	private String message = "Id is not Found ";

	public String getMessage() {
		return message;
	}

	public NoSuchElementFoundByMakeUpServiceException(String message) {
		super();
		this.message = message;
	}

	public NoSuchElementFoundByMakeUpServiceException() {
		super();

	}

}