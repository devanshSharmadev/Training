package com.phoneapp.exceptions;

public class PhoneNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PhoneNotFoundException() {
		
	}
	
	public PhoneNotFoundException(String message) {
		super(message);
	}

}
