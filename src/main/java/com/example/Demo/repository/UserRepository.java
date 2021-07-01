package com.example.Demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Demo.domain.User;
/**
 * @author Akash Budhwani
 *
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
