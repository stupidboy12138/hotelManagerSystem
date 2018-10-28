package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
	
	Admin findByUsernameAndPassword(String username,String password);
	
}
