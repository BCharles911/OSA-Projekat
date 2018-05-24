package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService implements UserServiceInterface {
	
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User findOne(Integer userId) {
		return userRepository.findOne(userId);
	}
	
	@Override
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	@Override
	public User save(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public void remove(Integer id) {
		userRepository.delete(id);
	}
	

}
