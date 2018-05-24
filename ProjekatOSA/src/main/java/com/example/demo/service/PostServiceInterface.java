package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Post;

public interface PostServiceInterface {
	
	
	//Optional???
	Post findOne(Integer postId);
	
	List<Post> findAll();
	
	Post save(Post title);
	
	void remove(Integer id);
	

}
