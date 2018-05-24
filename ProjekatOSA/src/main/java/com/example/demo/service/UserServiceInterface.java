package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;

public interface UserServiceInterface {
	
	User findOne(Integer userId);
	
	List<User> findAll();
	
	User save(User user);
	
	void remove(Integer id);
	
	
	
	

}
