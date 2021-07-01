package com.example.Demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Demo.domain.User;

public interface UserService {

	List<User> getAllUsers();
	
	User saveUser(User user);
	
	Optional<User> findById(Long id);
	
	void deleteById(Long id);
	
	
}
