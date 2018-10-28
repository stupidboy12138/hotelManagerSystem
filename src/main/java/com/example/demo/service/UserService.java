package com.example.demo.service;

import com.example.demo.domain.User;

public interface UserService {
	
	public User userinfo(String username);
	
	public User modifyPassword(User user);
	
	public void checkIn(User user);
	
	public void checkOut(Integer id);
	
	public boolean checkLock(Integer token , Integer roomid);

}
