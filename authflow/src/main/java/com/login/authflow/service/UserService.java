package com.login.authflow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.login.authflow.entity.AppUsers;
import com.login.authflow.repository.AppUsersRepository;

@Service
public class UserService {
	
	private final AppUsersRepository userRepo;
	private final PasswordEncoder passEncode;
	
	@Autowired
	public UserService(AppUsersRepository userRepo, PasswordEncoder passEncode) {
		this.userRepo = userRepo;
		this.passEncode = passEncode;
	}
	
	public AppUsers createUsers(AppUsers users) {
		users.setPassword(passEncode.encode(users.getPassword()));
		return userRepo.save(users);
	}

}
