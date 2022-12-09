package com.star;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	List<User> userList = new ArrayList<User>();
	
	
	@GetMapping("/all")
	public List<User> newUser() {
		userList.add(new User("admin", "one"));
		userList.add(new User("admin", "two"));
		userList.add(new User("admin", "three"));
		userList.add(new User("super", "one"));
		userList.add(new User("brian", "one"));
		userList.add(new User("admin", "kidiga"));
		userList.add(new User("noel", "joel"));
		
		return userList;
	}
	
	/***
	 * Creates a new user from the request body
	 * @param fname firstname from request body
	 * @param lname lastname from request body
	 */
	@PostMapping("/new")
	public User createUser(@PathVariable(name = "firstname") String fname, @PathVariable(name = "lastname") String lname) {
		User user = new User(fname,lname);
		return user;
	}
}
