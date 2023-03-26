package com.library.users.model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.hibernate.annotations.ManyToAny;

import com.library.books.model.Book;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "_users")
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique = true)
	private String username;
	
	@Column(unique = true)
	private String email;
	
	@ManyToMany(mappedBy = "borrowedBy")
	private Set<Book> books;
	
	private Date dateJoined;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	public User() {}
	
	public User(String username, String email, Date dateJoined) {
		this.username = username;
		this.email = email;
		this.dateJoined = dateJoined;
		this.books=new HashSet<>();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateJoined() {
		return dateJoined;
	}

	public void setDateJoined(Date dateJoined) {
		this.dateJoined = dateJoined;
	}

	public Long getId() {
		return id;
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Set<Book> getBooks() {
		return books;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", books=" + books + ", dateJoined="
				+ dateJoined + ", role=" + role + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(books, dateJoined, email, id, role, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(books, other.books) && Objects.equals(dateJoined, other.dateJoined)
				&& Objects.equals(email, other.email) && Objects.equals(id, other.id) && role == other.role
				&& Objects.equals(username, other.username);
	}

	
}
