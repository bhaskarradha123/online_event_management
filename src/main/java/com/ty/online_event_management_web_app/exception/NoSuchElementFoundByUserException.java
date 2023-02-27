package com.ty.online_event_management_web_app.exception;

public class NoSuchElementFoundByUserException extends RuntimeException {
	private String message = "Email is not Found ";

	public String getMessage() {
		return message;
	}

	public NoSuchElementFoundByUserException(String message) {
		super();
		this.message = message;
	}

	public NoSuchElementFoundByUserException() {
		super();

	}

}