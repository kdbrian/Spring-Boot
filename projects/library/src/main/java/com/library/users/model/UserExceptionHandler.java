package com.library.users.model;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ControllerAdvice
@Configuration
public class UserExceptionHandler {

	@Bean
	public Errorresponse getErrorResponse() {
		return new Errorresponse ();
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Errorresponse> handleUserNotFoundException(UserNotFoundException exception) {
		return new ResponseEntity<Errorresponse>(
				new Errorresponse(HttpStatus.NOT_FOUND.value(),
				exception.getMessage(),
				new Date(System.currentTimeMillis())
				), HttpStatus.NOT_FOUND
		);
	}
	
	@ExceptionHandler(UserExistsException.class)
	public ResponseEntity<Errorresponse> handleUserAlreadyExists(UserExistsException exception){
		return new ResponseEntity<Errorresponse>(
				new Errorresponse(HttpStatus.BAD_REQUEST.value(),
				exception.getMessage(),
				new Date(System.currentTimeMillis())
				), HttpStatus.BAD_REQUEST
		);
	}
	
	@ExceptionHandler(CannotDeleteAdminException.class)
	public ResponseEntity<Errorresponse> deleteAdminError(CannotDeleteAdminException exception){
		return new ResponseEntity<Errorresponse>(
				new Errorresponse(HttpStatus.UNAUTHORIZED.value(),
				exception.getMessage(),
				new Date(System.currentTimeMillis())
				), HttpStatus.UNAUTHORIZED
		);
	}
	
}

class Errorresponse {
	
	int statCode;
	private String message;
	private Date date;
	
	public Errorresponse() {
	}
	public Errorresponse(int statCode, String message, Date date) {
		super();
		this.statCode = statCode;
		this.message = message;
		this.date = date;
	}
	public int getStatCode() {
		return statCode;
	}
	public void setStatCode(int statCode) {
		this.statCode = statCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
