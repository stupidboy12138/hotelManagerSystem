package com.example.demo.service;

import com.example.demo.domain.Admin;

public interface AdminService {
	
	public Admin checkLogin(String username,String password); 
	
}
