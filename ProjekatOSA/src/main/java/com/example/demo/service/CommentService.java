package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Comment;
import com.example.demo.repository.CommentRepository;

@Service
public class CommentService implements CommentServiceInterface {
	
	
	@Autowired
	CommentRepository commentRepository;
	
	@Override
	public Comment findOne(Integer postId) {
		return commentRepository.findOne(postId);
	}
	
	@Override
	public List<Comment> findAll(){
		
		return commentRepository.findAll();
	}

	@Override
	public Comment save(Comment post) {
		
		return commentRepository.save(post);
		
	}

	@Override
	public void remove(Integer id) {
		commentRepository.delete(id);
		
	}
	


}
