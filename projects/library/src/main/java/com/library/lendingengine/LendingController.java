package com.library.lendingengine;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.books.model.Book;
import com.library.books.service.BookService;
import com.library.users.model.User;
import com.library.users.service.UserService;

@RestController
@RequestMapping("/api/v1/lend")
@Configuration
public class LendingController {

	private final UserService userService;
	private final BookService bookService;
	
	@Autowired
	public LendingController(UserService userService, BookService bookService) {
		this.userService = userService;
		this.bookService = bookService;
	}

	@GetMapping("/{book}/{user}")
	public ResponseEntity<LendResponse> lendBook(
			@PathVariable(name = "book") Long book_id, 
			@PathVariable(name = "user") Long user_id){
		
		
		//fetch the user
		User user = userService.getUsersById(user_id); 
		
		//check that the book exists
		final Book book = bookService.getBook(book_id);
		
		//add the book to the user's borrow list
		user.getBooks().add(book);
		
		//add the user to the book borrow list
		book.getBorrowedBy().add(user);
		
		//save both entities
		book.setNoInStock(book.getNoInStock()-1);
		bookService.updateBook(book);
		userService.updateUser(user);
		
		//return response
		return new ResponseEntity<LendResponse>(new LendResponse(
				user.getUsername(),
				book.getTitle(),
				new Date()), 
				HttpStatus.OK);
	}
	
	
	@Bean
	public LendResponse getLendResponse() {
		return new LendResponse();
	}
}

class LendResponse{
	private String usergiven;
	private String titleBookIssued;
	private Date dateLended;
	
	public LendResponse() {	}

	public LendResponse(String usergiven, String titleBookIssued, Date dateLended) {
		super();
		this.usergiven = usergiven;
		this.titleBookIssued = titleBookIssued;
		this.dateLended = dateLended;
	}

	public String getUsergiven() {
		return usergiven;
	}

	public void setUsergiven(String usergiven) {
		this.usergiven = usergiven;
	}

	public String getTitleBookIssued() {
		return titleBookIssued;
	}

	public void setTitleBookIssued(String titleBookIssued) {
		this.titleBookIssued = titleBookIssued;
	}

	public Date getDateLended() {
		return dateLended;
	}

	public void setDateLended(Date dateLended) {
		this.dateLended = dateLended;
	}
	
	
	
}
