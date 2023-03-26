package com.library.books.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.books.model.Book;
import com.library.books.model.BookNotFoundException;
import com.library.books.model.Genre;
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
	
	public Book getBookByTitle(String title) {
		List<Book> books = bookrepo.findAll();
		
		for(Book b: books)
			if(b.getTitle().equals(title))
				return b;
		throw new BookNotFoundException(title);
	}

	public List<Book> getAuthorBooks(String authorname) {
		
		List<Book> books = bookrepo.findAll();
		
		List<Book> authBooks = new ArrayList<>();
		
		for(Book b: books)
			if(b.getAuthor().equals(authorname))
				authBooks.add(b);
		return authBooks;
	}

	public List<Book> getGenreBooks(Genre genre) {
		
		List<Book> genreBooks = new ArrayList<>();
		
		for(Book b: bookrepo.findAll())
			if(b.getGenre().equals(genre))
				genreBooks.add(b);
		return genreBooks;
	}
	public void updateBook(Book book) {
		if(bookrepo.existsById(book.getId()))
			bookrepo.save(book);
		
		throw new BookNotFoundException(book.getId());
	}
}
