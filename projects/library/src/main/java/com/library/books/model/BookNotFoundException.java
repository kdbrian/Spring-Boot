package com.library.books.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BookNotFoundException extends RuntimeException {

	public BookNotFoundException(Long id) {
		super("Book with id "+id+" not found");
	}

	public BookNotFoundException(String message) {
		super("Book with title "+message+" does not exist");
	}

	
	
}
