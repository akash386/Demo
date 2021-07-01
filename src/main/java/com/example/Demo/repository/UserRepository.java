package com.example.Demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Demo.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
