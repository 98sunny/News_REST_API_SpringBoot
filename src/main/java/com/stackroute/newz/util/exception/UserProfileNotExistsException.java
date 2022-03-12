package com.stackroute.newz.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "Matching User Profile not found")
public class UserProfileNotExistsException extends RuntimeException {
	
	
	
String message;
	public UserProfileNotExistsException(String message) {
		super( message);
		// TODO Auto-generated constructor stub
		this.message=message;
	}

//	public UserProfileNotExistsException(Throwable cause) {
//		super(cause);
//		// TODO Auto-generated constructor stub
//	}

	public UserProfileNotExistsException() {
		// TODO Auto-generated constructor stub
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
}
