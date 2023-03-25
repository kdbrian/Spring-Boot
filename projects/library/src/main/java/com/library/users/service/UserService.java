package com.library.users.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.library.users.model.User;
import com.library.users.model.UserAdapter;
import com.library.users.model.UserNotFoundException;
import com.library.users.repo.UserRepository;

@Component
public class UserService{

	private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository, UserAdapter userAdapter) {
		this.userRepository = userRepository;
	}
	
	public User createUser(User new_user){
		return userRepository.save(new_user);
	}
	
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	public User getUsersById(Long id){
		Optional<User> u = userRepository.findById(id);
		
		if(u.isEmpty())
			throw new UserNotFoundException(id);
		
		return u.get();
	}
	
	public void deleteUser(Long id) {
		User user = getUsersById(id);
		
		userRepository.delete(user);
	}
}
