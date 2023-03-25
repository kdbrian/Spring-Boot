package com.library.users.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException  {

	public UserNotFoundException(Long id) {
		super("User with id "+id+" Not found");
	}

	

}
