package com.example.Demo.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@NoArgsConstructor
public class User {
	
	@Id 
	@NotNull
	@Column(name ="id", updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
    @Setter
	private  Long id;
	
	@Column(name = "first_name")
	@Getter
    @Setter
	private String firstName;
	
	@Column(name = "last_name")
	@Getter
    @Setter
	private String lastName;
	
	@Column(name = "email")
	@Getter
    @Setter
	private String email;
	
	@Column(name ="password")
	@Getter
    @Setter
	private String password;
	
	@Override
	public boolean equals( Object obj) {
		if ( this == obj)
			 return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		 return Objects.equals(firstName, other.firstName) &&
				 Objects.equals(lastName, other.lastName) &&
				 Objects.equals(email, other.email) &&
				 Objects.equals(password, other.password);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, email, password);
	}
	
	@Override
    public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User[ userId=").append(id)
		.append(",firstName=").append(firstName)
		.append(",lastName=").append(lastName)
		.append(",email=").append(email).append("]");
		return builder.toString();
		
	}

}

