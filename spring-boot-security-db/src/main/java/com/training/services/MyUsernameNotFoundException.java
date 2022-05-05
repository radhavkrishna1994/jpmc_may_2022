package com.training.services;

public class MyUsernameNotFoundException extends UserNameNotFoundException {

	private String message;
	
	public String getMessage() {
		return message;
	}

	public MyUsernameNotFoundException(String string) {
		this.message=message;
	}

	
}
