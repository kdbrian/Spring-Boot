/**
 * 
 */
package com.shopme.common.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ultimate
 *
 */

@Entity
@Table(name = "roles")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Integer id;
	
	@Column(length = 40, nullable= false, unique=true)
	private String name;
	
	@Column(length = 150, nullable=false)
	private String description;

	
	public Role() {
		// TODO Auto-generated constructor stub
	}
	
	/***
	 * 
	 * @param name
	 */
	public Role(String name) {
		// TODO Auto-generated constructor stub
		this.name=name;
	}
	
	/***
	 * 
	 * @param id
	 */
	public Role(Integer id) {
		this.id=id;
	}
	
	/**
	 * @param name
	 * @param description
	 */
	public Role(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return this.name;
	}

	/***
	 * @Override
	public String toString() {
		return "Role [name=" + name + "]";
	}
	 */
	
}
