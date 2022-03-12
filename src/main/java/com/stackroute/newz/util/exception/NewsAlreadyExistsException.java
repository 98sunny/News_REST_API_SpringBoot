package com.stackroute.newz.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "News already exists")
public class NewsAlreadyExistsException extends RuntimeException {
String message;

	public NewsAlreadyExistsException(String message) {
	super(message);
	this.message=message;
	// TODO Auto-generated constructor stub
}
	

	public NewsAlreadyExistsException() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
}
