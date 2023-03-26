package com.library.books.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BookNotFoundException extends RuntimeException {

	public BookNotFoundException(Long id) {
		super("Book with id "+id+" not found");
	}

	
}
