package com.library.books.controller;

import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.books.model.Book;
import com.library.books.model.BookAdapter;
import com.library.books.model.BookExistsException;
import com.library.books.model.Genre;
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
	
	/**
	 * Checks if a book exists by the title
	 * @param title
	 * @return
	 */
	public boolean checkBook(String title) {
		List<Book> books = service.getBooks();
		for(Book book : books)
			if(book.getTitle().equals(title)) {
				return true;
			}
		return false;
	}
	
	@PostMapping("/new")
	public ResponseEntity<Book> createBook(@RequestBody BookAdapter bookAdapter){
		if(checkBook(bookAdapter.getTitle())) {
			throw new BookExistsException(bookAdapter.getTitle());
		}
		
		Book book = new Book(
				bookAdapter.getTitle(), 
				bookAdapter.getAuthor(), 
				bookAdapter.getStock(),
				Genre.valueOf(bookAdapter.getGenre().toUpperCase()),
				bookAdapter.getPages()
		);
		
		return new ResponseEntity<Book>(service.insertBook(book), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBookByID(@PathVariable Long id) {
		return ResponseEntity.ok(service.getBook(id));
	}
	
	@GetMapping("")
	public ResponseEntity<Book> getBookByTitle(@RequestParam(name = "title") String title) {
		return ResponseEntity.ok(service.getBookByTitle(title));
	}
	
	@GetMapping("/author")
	public ResponseEntity<List<Book>> getAuthorBooks(@RequestParam(name = "name") String authorname){
		return ResponseEntity.ok(service.getAuthorBooks(authorname));
	}
	
	@GetMapping("/genre")
	public ResponseEntity<List<Book>> getGenreBooks(@RequestParam(name = "g") Genre genre){
		return ResponseEntity.ok(service.getGenreBooks(genre));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteBookByID(@PathVariable Long id) {
		service.deleteBook(id);
		return new ResponseEntity<>("Deleted book with id"+id, HttpStatus.NO_CONTENT); 
	}
	
}
