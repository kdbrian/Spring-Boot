/**
 * 
 */
package com.shopme.admin.user;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shopme.common.entity.Role;
import com.shopme.common.entity.User;

/**
 * @author ultimate
 *
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<User> listAll(){
		return (List<User>) userRepository.findAll();
	}
	
	public List<Role> listRoles(){
		return (List<Role>) roleRepository.findAll();
	}

	public void save(User user) {
		// TODO Auto-generated method stub
		
		// if true is in updating
		boolean isUpdating = (user.getId() != null);
		
		if(isUpdating) {
			User exsistingUser = userRepository.findById(user.getId()).get();
			
			//check if password field is empty in edit form
			if(exsistingUser.getPassword().isEmpty()) {
				//means password is unchanged
				//set user password to the one in the db
				user.setPassword(exsistingUser.getPassword());
			}else {
				//means the password is changed
				encodePassword(user);
			}
			
		}else {
			//encode pwd before saving to db
			encodePassword(user);
		}
		userRepository.save(user);
	}
	
	private void encodePassword(User user) {
		String encodedPwd = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPwd);
		
	}
	
	public boolean isEmailUnique(String email,Integer id) {
		User user = userRepository.getUserByEmail(email);
		
		if(user == null) return true;
		
		//condition whre a new user is being created
		boolean isNew = (id== null);
		
		// if the user is new but the email has been taken
		if(isNew && user != null)
			return false;
		else {
			if(user.getId() != id) {
				return false;
			}
		}
		
		//returns true if no user exists with that email
		return true;
	}

	public User get(Integer id) throws UserNotfoundException {
		// TODO Auto-generated method stub
		try {return userRepository.findById(id).get();}
		catch (NoSuchElementException e) {
			// TODO: handle exception
			throw new UserNotfoundException("User with ID:"+id+"Not found");
		}
	}
	
	public void deleteUser(Integer id) throws UserNotfoundException{
		if( userRepository.countById(id) == null || userRepository.countById(id)==0) {
			throw new UserNotfoundException("User with Id : "+id+" not found");
		}
		
		userRepository.deleteById(id);
	}

}
 