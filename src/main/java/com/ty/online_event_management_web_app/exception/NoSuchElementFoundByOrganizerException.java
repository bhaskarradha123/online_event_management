package com.ty.online_event_management_web_app.exception;

public class NoSuchElementFoundByOrganizerException extends RuntimeException {
	private String message = "email is not Found ";

	public String getMessage() {
		return message;
	}

	public NoSuchElementFoundByOrganizerException(String message) {
		super();
		this.message = message;
	}

	public NoSuchElementFoundByOrganizerException() {
		super();

	}

}