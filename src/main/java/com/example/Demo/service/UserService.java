package com.example.Demo.service;

import java.util.List;
import java.util.Optional;
import com.example.Demo.domain.User;
/**
 * @author Akash Budhwani
 *
 */
public interface UserService {

	List<User> getAllUsers();
	
	User saveUser(User user);
	
	Optional<User> findById(Long id);
	
	void deleteById(Long id);
	
	
}
