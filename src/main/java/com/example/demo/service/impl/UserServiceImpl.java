package com.example.demo.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Override
	public User userinfo(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	@Transactional
	public User modifyPassword(User user) {
		return userRepository.save(user);
	}

	@Override
	@Transactional
	public void checkIn(User user) {
		userRepository.save(user);
	}

	@Override
	@Transactional
	public void checkOut(Integer id) {
		userRepository.deleteById(id);
	}

	@Override
	public boolean checkLock(Integer token, Integer roomid) {
		return false;
	}
	

}
