package com.library.users.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UserExistsException extends RuntimeException {

	public UserExistsException() {
		super("user with same details already exists");
		// TODO Auto-generated constructor stub
	}

	
}
