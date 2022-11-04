/**
 * 
 */
package com.shopme.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.shopme.common.entity.Role;
import java.util.List;
/**
 * @author ultimate
 *
 */

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)// allows the data to be saved in the db after the test is complete
public class RoleRepositoryTests {
	
	@Autowired
	private RoleRepository roleRepository;
	
	/***
	 * A test to create the first role ( admin -> manage everything )
	 */
	@Test
	public void testCreateFirstRole() {
		
		// creating a new role
		Role roleAdmin = new Role("Admin","manage everything"); 
		
		// saving the role to the database
		Role savedRole = roleRepository.save(roleAdmin);
		
		// checking the id of the inserted role
		assertThat(savedRole.getId()).isGreaterThan(0);
		// meaning that the role has been inserted into the db
		
	}
	
	/***
	 * Test to insert the rest roles into the database
	 */
	@Test
	public void createRestRoles() {
		Role roleSalesPerson = new Role("SalesPerson","manage product price, customers, shipping, orders and sales report");
		Role roleEditor = new Role("Editor","manage categories, brands, products, articles and menus");
		Role roleShipper = new Role("Shipper","view products, view orders and update order status");
		Role roleAssistant = new Role("Assistant","manage questions and reviews");
		
		roleRepository.saveAll(List.of(roleSalesPerson,roleEditor,roleShipper,roleAssistant));
		
	}
	
}
