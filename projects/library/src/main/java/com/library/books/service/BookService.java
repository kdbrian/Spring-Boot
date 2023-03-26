package com.library.books.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.books.model.Book;
import com.library.books.model.BookNotFoundException;
import com.library.books.repo.BookRepository;

@Component
public class BookService {
	
	private final BookRepository bookrepo;

	@Autowired
	public 	BookService(BookRepository repository) {
		this.bookrepo = repository;
	}
	
	public Book getBook(Long id) {
		Optional<Book > book =  bookrepo.findById(id);
		
		if(book.isEmpty())
			throw new BookNotFoundException(id); 
		
		return book.get();
	}
	
	public Book insertBook(Book book) {
		return bookrepo.save(book);
	}
	
	public List<Book> getBooks(){
		return bookrepo.findAll();
	}
	
	public void deleteBook(Long id) {
		Book b = getBook(id);
		
		bookrepo.delete(b);
	}
}
