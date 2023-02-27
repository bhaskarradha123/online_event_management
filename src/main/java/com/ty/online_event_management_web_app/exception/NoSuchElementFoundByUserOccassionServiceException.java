package com.ty.online_event_management_web_app.exception;

public class NoSuchElementFoundByUserOccassionServiceException extends RuntimeException {

	private String message = "id is not Found ";

	public String getMessage() {
		return message;
	}

	public NoSuchElementFoundByUserOccassionServiceException(String message) {
		super();
		this.message = message;
	}

	public NoSuchElementFoundByUserOccassionServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

}
