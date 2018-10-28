package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findByUsername(String username);
	
	User findByUsernameAndPassword(String username,String password);
	
}
