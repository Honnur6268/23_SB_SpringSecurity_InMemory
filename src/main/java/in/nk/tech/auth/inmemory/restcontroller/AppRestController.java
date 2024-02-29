package in.nk.tech.auth.inmemory.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppRestController {

	@GetMapping("/")
	public String home() {
		return "Hi, Welcome";
	}
	
	@GetMapping("/login/admin")
	public String adminHome() {
		return "Hi, Welcome to admin dashboard";
	} 
	
	@GetMapping("/login/user")
	public String userHome() {
		return "Hi, Welcome to user dashboard";
	} 
}
