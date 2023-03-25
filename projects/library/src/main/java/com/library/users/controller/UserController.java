package com.library.users.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.users.model.User;
import com.library.users.model.UserAdapter;
import com.library.users.repo.UserRepository;
import com.library.users.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	private final UserAdapter userAdapter;
	private final UserService userService;

	@Autowired
	public UserController(UserAdapter userAdapter, UserService userService) {
		this.userAdapter = userAdapter;
		this.userService=userService;
	}


	@PostMapping("/new")
	public ResponseEntity<User> createUser(@RequestBody UserAdapter adapter){
		User user = new User();
		user.setDateJoined(new Date(System.currentTimeMillis()));
		user.setUsername(adapter.getUsername());
		user.setEmail(adapter.getEmail());
		
		return ResponseEntity.ok(userService.createUser(user));
	}
	
	@GetMapping("/")
	public ResponseEntity<List<User>> getUsers(){
		return ResponseEntity.ok(userService.getUsers());
	}
}
