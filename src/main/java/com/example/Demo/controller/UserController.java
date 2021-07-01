/**
 * 
 */
package com.example.Demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Demo.domain.User;
import com.example.Demo.dto.UserDTO;
import com.example.Demo.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author LENOVO
 *
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserService userService;
	
    @PostMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDTO userDetails) 
    {
    	log.info("Inside UserController :: createUser() ");
    	log.debug("RequestBody =" + userDetails);
    	User user = null;
    	try
    	{

	        User newUser = new User();
	        newUser.setFirstName(userDetails.getFirstName());
	        newUser.setLastName(userDetails.getLastName());
	        newUser.setEmail(userDetails.getEmail());
	        newUser.setPassword(userDetails.getPassword());
	        user = userService.saveUser(newUser);
			return new ResponseEntity<>(user.toString(),HttpStatus.CREATED);
	    }
		catch(Exception e)
		{
			log.error("Exception in UserController :: createUser() " + e.getMessage());
			throw new RuntimeException(this.getClass().getName());
		}
  	}
    
    @PutMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateUser(@PathVariable("id") long id, @Valid @RequestBody UserDTO userDetails) 
    {
    	log.info("Inside UserController :: updateUser() ");
    	log.debug("RequestBody =" + userDetails);
    	try
    	{
    		User userObj = null;
    		if(userService.findById(id).isPresent())
        	{
    			Optional<User> user = userService.findById(id);
    			User newUser = new User();
    			newUser.setId(userDetails.getId());
    	        newUser.setFirstName(userDetails.getFirstName());
    	        newUser.setLastName(userDetails.getLastName());
    	        newUser.setEmail(userDetails.getEmail());
    	        newUser.setPassword(userDetails.getPassword());
	        	if(!newUser.equals(user.get()))
	        	{
	        		user.get().setFirstName(userDetails.getFirstName());
	        		user.get().setLastName(userDetails.getLastName());
	        		user.get().setEmail(userDetails.getEmail());
	        		user.get().setPassword(userDetails.getPassword());
	        		userObj = userService.saveUser(user.get());
	    			return new ResponseEntity<>(userObj.toString(),HttpStatus.OK);
	        	}
				return new ResponseEntity<>("No Data change",HttpStatus.OK);
        	}
        	return new ResponseEntity<String>("No data found",HttpStatus.NOT_FOUND);
	    }
		catch(Exception e)
		{
			log.error("Exception in UserController :: updateUser() " + e.getMessage());
			throw new RuntimeException(this.getClass().getName());
		}
  	}
    
    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllUser() 
    {
    	log.info("Inside UserController :: getAllUser() ");
        List<User> userList = new ArrayList<>();
        try
        {
        	userList = userService.getAllUsers().stream()
        			.map( userObj -> {
        				User user  = new User();
        				user.setId(userObj.getId());
        				user.setFirstName(userObj.getFirstName());
        				user.setLastName(userObj.getLastName());
        				user.setEmail(userObj.getEmail());
        				return user;
        			}).collect(Collectors.toList());
			if(!userList.isEmpty())
			{
				return new ResponseEntity<>(userList.toString(),HttpStatus.OK);
			}
			return new ResponseEntity<String>("No data found",HttpStatus.NOT_FOUND);
        }
        catch(Exception e)
		{
        	log.error("Exception in UserController :: getAllUser() " + e.getMessage());
			throw new RuntimeException(this.getClass().getName());
		}
    }
    
    @DeleteMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteUserById(@PathVariable("id") long id) 
    {
    	log.info("Inside UserController :: deleteUserById() ");
        try
        {
        	if(userService.findById(id).isPresent())
        	{
	        	userService.deleteById(id);
				return new ResponseEntity<>("Data Deleted",HttpStatus.OK);
        	}
        	return new ResponseEntity<String>("No data found",HttpStatus.NOT_FOUND);
        }
        catch(Exception e)
		{
        	log.error("Exception in UserController :: deleteUserById() " + e.getMessage());
			throw new RuntimeException(this.getClass().getName());
		}
    }
    
}
