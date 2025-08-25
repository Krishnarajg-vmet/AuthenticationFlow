package com.login.authflow.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.login.authflow.entity.AppUsers;
import com.login.authflow.repository.AppUsersRepository;

@Service
public class CustomUserDetailsService implements  UserDetailsService{
	
	private final AppUsersRepository userRepo;
	
	public CustomUserDetailsService(AppUsersRepository userRepo) {
		this.userRepo = userRepo;
	}
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUsers users = userRepo.findByUsername(username)
				.orElseThrow(()->new UsernameNotFoundException("Username not found"));
		
		return User.withUsername(users.getUsername())
				.password(users.getPassword())
				.authorities(users.getRoles().toArray(new String[0]))
				.build();
	}

}
