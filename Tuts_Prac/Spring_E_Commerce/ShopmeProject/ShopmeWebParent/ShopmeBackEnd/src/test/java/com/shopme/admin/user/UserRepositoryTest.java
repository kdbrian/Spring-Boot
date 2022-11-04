/**
 * 
 */
package com.shopme.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.shopme.common.entity.Role;
import com.shopme.common.entity.User;

/**
 * @author ultimate
 *
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	/***
	 * test for creating a user with a single role
	 */
	@Test
	public void testCreateUserWithOneRole() {
		
		//finding  specific role from the database
		// finds the role with the Id 1
		Role roleAdminRole = entityManager.find(Role.class, 1);
		
		User user=new User("BRIAN","KIDIGA","brian@dev.io","test1234");
		
		user.addRole(roleAdminRole);
		
		User createdUser = userRepository.save(user);
		
		assertThat(createdUser.getId()).isGreaterThan(0);
		
	}
	
	/***
	 * Test for creating a user with two roles
	 */
	@Test
	public void testCreateUserWithTwoRoles() {
		
		//Role roleAdminRole = entityManager.find(Role.class, 1);
		//Role roleAdminRole = entityManager.find(Role.class, 1);
		
		User user=new User("BRIAN","KIDIGA","brian1@dev.io","test1234");
		
		Role roleEditor = new Role(3);
		Role roleAssistant = new Role(5);
		
		user.addRole(roleEditor);
		user.addRole(roleAssistant);
		
		User createdUser = userRepository.save(user);
		
		assertThat(createdUser.getId()).isGreaterThan(0);
		
	}

	/***
	 * test method to list all users in the database
	 */
	@Test
	public void listAllUsers() {
		
		Iterable<User> listUsers = userRepository.findAll();
		
		listUsers.forEach(System.out::println);
	}
	
	/***
	 * test method to get a user by ID
	 */
	@Test
	public void testGetUserById() {
		User usr= userRepository.findById(2).get();
		System.out.println(usr);
		assertThat(usr).isNotNull();
	}
	
	
	/***
	 * test method to update a user by ID
	 */
	@Test
	public void testUpdateUserDetails() {
		// get user object from the database
		User usr = userRepository.findById(1).get();
		usr.setEnabled(true);
		usr.setEmail("testupdate@dev.io");
		userRepository.save(usr);
	}
	
	/***
	 * test method to get a user by ID
	 */
	@Test
	public void testUpdateUserRoles() { 
		
		//find the user
		User usr2 = userRepository.findById(2).get();
		
		Role editor = new Role(3);
		Role salesPerson = new Role(2);
		
		usr2.getRoles().remove(editor);
		usr2.addRole(salesPerson);
		
		userRepository.save(usr2);
		
	}
	
	
	@Test
	public void testDeleteUser() {
		Integer userIdInteger = 2;
		userRepository.deleteById(userIdInteger);
	}
	
	@Test
	public void testGetUserByEmail() {
		String email = "juniorprogrammer09@gmail.com";
		User user = userRepository.getUserByEmail(email);
		
		assertThat(user).isNotNull();
	}
	
	@Test
	public void testCountById() {
		Integer id=3;
		Long num= userRepository.countById(id);
		assertThat(num).isNotNull().isGreaterThan(0);
	}
}
