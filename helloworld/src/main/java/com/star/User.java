package com.star;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class User {

	private String id;

	private String fname;

	private String lname;

	private LocalDate dateJoined;

	private boolean isActive;
	
	private Role role;
	
	private enum Role{
		ADMIN,USER,OTHER,SUPERUSER
	}
	
	public User(String fname, String lname) {
		this.fname = fname;
		this.lname = lname;
		this.id = this.generateId().toString();
		this.dateJoined=LocalDate.now();
		this.isActive=true;
		this.role=Role.SUPERUSER;
		
	}

	/**
	 * @param id the id to set
	 */
	public String generateId() {
		return UUID.randomUUID().toString();
	}

	/**
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}

	/**
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}

	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}

	/**
	 * @param lname the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}

	/**
	 * @return the dateJoined
	 */
	public LocalDate getDateJoined() {
		return dateJoined;
	}

	/**
	 * @param dateJoined the dateJoined to set
	 */
	public void setDateJoined(LocalDate dateJoined) {
		this.dateJoined = dateJoined;
	}

	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public String toString() {
		return "id@"+this.getId();
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id.toString();
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

}
