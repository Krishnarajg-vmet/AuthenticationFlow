package com.login.authflow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@GetMapping("/home")
	public String homePage() {
		return "home";
	}
	
	@GetMapping("/public/users")
	public String usersPage() {
		return "users";
	}

}
