package com.library.books.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FOUND)
public class BookExistsException extends RuntimeException {

	public BookExistsException(String message) {
		super("Book with title "+message+ " already exists");
	}

}
