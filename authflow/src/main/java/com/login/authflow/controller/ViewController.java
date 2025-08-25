package com.login.authflow.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@GetMapping("/home")
	public String homePage(Model model, Principal principal) {
		model.addAttribute("username", principal.getName());
		return "home";
	}
	
	@GetMapping("/public/users")
	public String usersPage() {
		return "users";
	}

}
