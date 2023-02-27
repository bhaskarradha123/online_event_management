package com.ty.online_event_management_web_app.exception;

public class NoSuchElementFoundByVenueServiceException extends RuntimeException {
	private String message = "Id is not Found ";

	public String getMessage() {
		return message;
	}

	public NoSuchElementFoundByVenueServiceException(String message) {
		super();
		this.message = message;
	}

	public NoSuchElementFoundByVenueServiceException() {
		super();

	}

}