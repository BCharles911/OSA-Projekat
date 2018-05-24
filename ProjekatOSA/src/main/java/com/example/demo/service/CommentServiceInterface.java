package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Comment;



public interface CommentServiceInterface {
	
	Comment findOne(Integer commentId);
	
	List<Comment> findAll();
	
	Comment save(Comment title);
	
	void remove(Integer id);

}
