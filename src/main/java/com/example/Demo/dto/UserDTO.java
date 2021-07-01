package com.example.Demo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
/**
 * @author Akash Budhwani
 *
 */
public class UserDTO {
	
	@Getter
    @Setter
	private Long id;
	
    @NotNull(message="First name cannot be missing or empty")
    @Size(min=2, message="First name must not be less than 2 characters")
    @Getter
    @Setter
    private String firstName;
    
    @NotNull(message="Last name cannot be missing or empty")
    @Size(min=2, message="Last name must not be less than 2 characters")
    @Getter
    @Setter
    private String lastName;
    
    @Email
    @Getter
    @Setter
    private String email;
    
    @NotNull(message="Password is a required field")
    @Size(min=8, max=16, message="Password must be equal to or greater than 8 characters and less than 16 characters")
    @Getter
    @Setter
    private String password;
    
}