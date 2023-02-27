package com.ty.online_event_management_web_app.exception;

public class NoSuchElementFoundByPhotographerServiceException extends RuntimeException {
	private String message = "Id is not Found ";

	public String getMessage() {
		return message;
	}

	public NoSuchElementFoundByPhotographerServiceException(String message) {
		super();
		this.message = message;
	}

	public NoSuchElementFoundByPhotographerServiceException() {
		super();

	}

}