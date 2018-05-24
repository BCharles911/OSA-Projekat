package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Post;
import com.example.demo.repository.PostRepository;

@Service
public class PostService implements PostServiceInterface {
	
	
	
	@Autowired
	PostRepository postRepository;
	
	@Override
	public Post findOne(Integer postId) {
		return postRepository.findOne(postId);
	}
	
	@Override
	public List<Post> findAll(){
		
		return postRepository.findAll();
	}

	@Override
	public Post save(Post post) {
		
		return postRepository.save(post);
		
	}

	@Override
	public void remove(Integer id) {
		postRepository.delete(id);
		
	}
	


}
