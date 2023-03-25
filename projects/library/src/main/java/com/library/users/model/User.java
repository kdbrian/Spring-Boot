package com.library.users.model;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "_users")
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String username;
	
	private String email;
	
	private Date dateJoined;
	
	public User() {}
	
	public User(String username, String email, Date dateJoined) {
		this.username = username;
		this.email = email;
		this.dateJoined = dateJoined;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", dateJoined=" + dateJoined + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateJoined, email, id, username);
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
		return Objects.equals(dateJoined, other.dateJoined) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(username, other.username);
	}

	
}
