package com.library.books.model;

import java.util.Objects;

import com.fasterxml.jackson.databind.cfg.EnumFeature;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

	static int counter;
	
	static {
		counter=1;
	}
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Id
	private String title;
	
	private String author;
	
	private int noInStock;
	
	private String genre;

	public Book() {}
	
	public Book(String title, String author, int noInStock, String genre) {
		this.id=(long) counter;
		this.title = title;
		this.author = author;
		this.noInStock = noInStock;
		this.genre = genre;
		counter++;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public int getNoInStock() {
		return noInStock;
	}

	public String getGenre() {
		return genre;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setNoInStock(int noInStock) {
		this.noInStock = noInStock;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", noInStock=" + noInStock + ", genre="
				+ genre + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, genre, id, noInStock, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && genre == other.genre && Objects.equals(id, other.id)
				&& noInStock == other.noInStock && Objects.equals(title, other.title);
	}
	
	
	
	
	
}
