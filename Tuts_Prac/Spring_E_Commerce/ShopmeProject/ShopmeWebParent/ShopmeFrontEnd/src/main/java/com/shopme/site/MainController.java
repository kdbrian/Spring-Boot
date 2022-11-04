/**
 * 
 */
package com.shopme.site;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ultimate
 *
 */

@Controller
public class MainController {
	
	@GetMapping
	public String viewHomePage() {
		return "index";
	}

}
