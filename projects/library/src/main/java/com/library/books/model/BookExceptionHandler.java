package com.library.books.model;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Configuration
public class BookExceptionHandler {
	
	@Bean
	public Errorresponse getErrorresponse() {
		return new Errorresponse();
	}

	@ExceptionHandler(BookExistsException.class)
	public ResponseEntity<Errorresponse> handleBookExistsException(BookExistsException exception){
		Errorresponse response = new Errorresponse(
				HttpStatus.FOUND.value(),
				new Date(),
				exception.getMessage()
		);
		
		return new ResponseEntity<Errorresponse>(response, HttpStatus.FOUND);
	}
	
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<Errorresponse> handleBooNotFoundException(BookNotFoundException exception){
		return new ResponseEntity<>(
				new Errorresponse(HttpStatus.NOT_FOUND.value(), new Date(), exception.getMessage()),
				HttpStatus.NOT_FOUND
		);		
	}
	
}

class Errorresponse{
	
	int statuscode;
	Date date;
	String message;
	public Errorresponse() {
		
	}
	
	
	public Errorresponse(int code, Date date, String message) {
		this.statuscode = code;
		this.date = date;
		this.message = message;
	}


	public int getCode() {
		return statuscode;
	}
	public Date getDate() {
		return date;
	}
	public String getMessage() {
		return message;
	}
	
}
