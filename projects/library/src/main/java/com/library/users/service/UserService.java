package com.library.users.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.library.books.model.Book;
import com.library.books.model.BookNotFoundException;
import com.library.users.model.CannotDeleteAdminException;
import com.library.users.model.Role;
import com.library.users.model.User;
import com.library.users.model.UserAdapter;
import com.library.users.model.UserExistsException;
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
		if(checkEmail(new_user.getEmail()) || checkUserName(new_user.getUsername()))
			throw new UserExistsException();
		new_user.setRole(Role.USER);
		return userRepository.save(new_user);
	}
	
	private boolean checkUserName(String username) {
		for(User user : userRepository.findAll()) {
			if(user.getUsername().equals(username))
				return true;
		}
		return false;
	}

	private boolean checkEmail(String email) {
		for(User user : userRepository.findAll()) {
			if(user.getEmail().equals(email))
				return true;
		}
		return false;
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
		
		if(user.getRole().equals(Role.ADMIN))
			throw new CannotDeleteAdminException();
		
		userRepository.delete(user);
	}
	
	public List<Role> getRoles() {
		return List.of(Role.values());
	}
	
	public void updateUser(User user) {
		if(userRepository.existsById(user.getId()))
			userRepository.save(user);
		
		throw new UserNotFoundException(user.getId());
	}
}
