package com.library.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.books.model.Book;
import com.library.books.service.BookService;


@RestController
@RequestMapping("/api/v1/books")
public class BookController {

	private final BookService service;
	
	@Autowired
	public BookController(BookService bookService) {
		this.service=bookService;
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<Book>> getBooks(){
		return ResponseEntity.ok(service.getBooks());
	}
	
	@PostMapping("/new")
	public ResponseEntity<Book> createBook(@RequestBody Book book){
		return new ResponseEntity<Book>(service.insertBook(book), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBookByID(@PathVariable String id) {
		return ResponseEntity.ok(service.getBook(Long.parseLong(id)));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteBookByID(@PathVariable String id) {
		service.deleteBook(Long.parseLong(id));
		return new ResponseEntity<>("Deleted book with id"+id, HttpStatus.NO_CONTENT); 
	}
	
}
