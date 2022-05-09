package com.training.exceptions;

public class BookNotFoundException extends Exception {

	private String message;
	public String getMessage() {
		return message;
	}
	public BookNotFoundException(String message) {
		this.message=message;
	}

}
