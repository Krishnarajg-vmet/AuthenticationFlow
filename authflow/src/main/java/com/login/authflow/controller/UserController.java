package com.login.authflow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.login.authflow.entity.AppUsers;
import com.login.authflow.service.UserService;

@Controller
public class UserController {
	
	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/public/users")
	public String createUser(@ModelAttribute AppUsers user) {
	    // Spring will bind fields based on name matching
	    userService.createUsers(user);
	    System.out.println(user.getUsername() + " " + user.getPassword() + " " + user.getRoles());
	    return "redirect:/public/users";
	}

}
