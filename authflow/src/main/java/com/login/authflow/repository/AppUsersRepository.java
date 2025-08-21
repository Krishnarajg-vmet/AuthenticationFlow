package com.login.authflow.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.login.authflow.entity.AppUsers;

@Repository
public interface AppUsersRepository extends JpaRepository<AppUsers, Long>{
	
	Optional<AppUsers> findByUsername(String username);

}
