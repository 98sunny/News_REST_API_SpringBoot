package com.stackroute.newz.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "News with specified details not found")
public class NewsNotExistsException extends RuntimeException {
	
	private String message;
	public NewsNotExistsException(String message) {
		super(message);
		this.message=message;
		// TODO Auto-generated constructor stub
	}
	public NewsNotExistsException() {
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
