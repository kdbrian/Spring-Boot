package com.library.books.model;

import java.util.Objects;

import com.fasterxml.jackson.databind.cfg.EnumFeature;

import jakarta.persistence.Column;
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
	
	@Column(unique = true)
	private String title;

	@Id
	@GeneratedValue
	private Long id;
	
	private String author;
	
	private int noInStock;
	
	@Enumerated(EnumType.STRING)
	private Genre genre;
	
	private int noOfPages;

	public Book() {}
	
	public Book(String title, String author, int noInStock,Genre genre, int pages) {
		this.title = title;
		this.author = author;
		this.noInStock = noInStock;
//		genre=genre.toUpperCase();
		this.genre = genre;
		this.noOfPages=pages;
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

	public Genre getGenre() {
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

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public int getNoOfPages() {
		return noOfPages;
	}

	public void setNoOfPages(int noOfPages) {
		this.noOfPages = noOfPages;
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
