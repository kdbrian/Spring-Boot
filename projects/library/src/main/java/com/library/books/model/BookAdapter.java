package com.library.books.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookAdapter {
		
	private String title;
	
	private int pages;
	
	private String author;
	
	private int stock;
	
	private String genre;
}
