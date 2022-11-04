/**
 * 
 */
package com.shopme.admin.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shopme.common.entity.Role;
import com.shopme.common.entity.User;

/**
 * @author ultimate
 *
 */

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public String listAll(Model model) {
		List<User> users = userService.listAll();
		model.addAttribute("listusers", users);
		return "users";
	}
	
	@GetMapping("/users/new")
	public String newUser(Model model) {
		User user = new User();
		user.setEnabled(true);
		List<Role> roles = userService.listRoles();
		model.addAttribute("user",user);
		model.addAttribute("roles",roles);
		model.addAttribute("pageTitle","Create User");
		return "user_form";
	}
	
	@PostMapping("/users/save")
	public String saveUser(User user,RedirectAttributes redirectAttributes) {
		userService.save(user);
		
		redirectAttributes.addFlashAttribute("message","The user has been saved successfully.");
		
		return "redirect:/users"; //redirects to the all users page
	}
	
	@GetMapping("/users/edit/{id}")
	public String getUserEditForm(@PathVariable (name = "id")Integer id, Model model ,RedirectAttributes redirectAttributes) {
		
		try {
			//retrieve user from db
			User user = userService.get(id);
			model.addAttribute("user",user);
			List<Role> roles = userService.listRoles();
			model.addAttribute("roles",roles);
			model.addAttribute("pageTitle","Edit User <Id:"+id+">");
			return "user_form";
			
		}catch (UserNotfoundException e) {
			// TODO: handle exception
			//redirectiong with a flash to the user indicating the user with that id has not been found
			redirectAttributes.addFlashAttribute("message",e.getMessage());
			return "redirect:/users"; //redirects to the all users page
		}

	}
	
	@GetMapping("/users/delete/{id}")
	public String deleteUser(@PathVariable (name = "id")Integer id,RedirectAttributes redirectAttributes) {
		
		try {
			
			userService.deleteUser(id);
			redirectAttributes.addFlashAttribute("message","User with id: "+id+"was deleted");
			
		}catch (UserNotfoundException e) {
			// TODO: handle exception
			//redirectiong with a flash to the user indicating the user with that id has not been found
			redirectAttributes.addFlashAttribute("message",e.getMessage());
			return "redirect:/users"; //redirects to the all users page
		}
		
		return "redirect:/users"; //redirects to the all users page}
			
	}
	
}
