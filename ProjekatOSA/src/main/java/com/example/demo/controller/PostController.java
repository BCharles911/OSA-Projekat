package com.example.demo.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PostDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.Post;
import com.example.demo.service.PostServiceInterface;
import com.example.demo.service.UserServiceInterface;





/**
 * @author User
 *
 */
@RestController
@RequestMapping(value="api/posts")
public class PostController {
	
	@Autowired
	private PostServiceInterface postService;
	
	@Autowired
	private UserServiceInterface userService;
	
	
	
	@GetMapping
	
	public ResponseEntity<List<PostDTO>> getPosts(){
		
		
		List<Post> posts = postService.findAll();
		List<PostDTO> postsDTO = new ArrayList<PostDTO>();
		for(Post p : posts) {
			postsDTO.add(new PostDTO(p));
		}
		return new ResponseEntity<List<PostDTO>>(postsDTO, HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<PostDTO> getPost(@PathVariable("id") Integer id){
		Post post = postService.findOne(id);
		if(post == null) {
			return new ResponseEntity<PostDTO>(HttpStatus.NOT_FOUND);
			
		}
		return new ResponseEntity<PostDTO>(new PostDTO(post), HttpStatus.OK);
	}
	
	
	@PostMapping(consumes="application/json")
	public ResponseEntity<PostDTO> savePost(@RequestBody PostDTO postDTO){
		
		Post post = new Post();
		post.setTitle(postDTO.getTitle());
		post.setDescription(postDTO.getDescription());
		post.setLongitude(postDTO.getLongitude());
		post.setLatitude(postDTO.getLatitude());
		post.setDate(postDTO.getDate());
		//post.setAuthor(userService.findOne(postDTO.getId()));
		post.setLikes(postDTO.getLikes());
		post.setDislikes(postDTO.getDislikes());
		
		post = postService.save(post);
		return new ResponseEntity<PostDTO>(new PostDTO(post), HttpStatus.CREATED);
		
		
	}
	
	
	
	
	@PutMapping(value="/{id}", consumes="application/json")
	public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO postDTO, @PathVariable("id") Integer id){
		Post post = postService.findOne(id);
		
		if(post == null) {
			return new ResponseEntity<PostDTO>(HttpStatus.BAD_REQUEST);
		}
		
		post.setTitle(postDTO.getTitle());
		post.setDescription(postDTO.getDescription());
		post.setDate(postDTO.getDate());
		//post.setAuthor(userService.findOne(postDTO.getId()));
		post.setLikes(postDTO.getLikes());
		post.setDislikes(postDTO.getDislikes());
		
		post = postService.save(post);
		return new ResponseEntity<PostDTO>(new PostDTO(post), HttpStatus.OK);
	}
	
	
	
	@PatchMapping(consumes = "application/json")
	public ResponseEntity<PostDTO> updateLikesDislikes(@RequestBody PostDTO postDTO)
	{
		Post post = postService.findOne(postDTO.getId());
		if(post == null)
			return new ResponseEntity<PostDTO>(HttpStatus.BAD_REQUEST);
		if(post.getLikes() != postDTO.getLikes())
			post.setLikes(postDTO.getLikes());
		if(post.getDislikes() != postDTO.getDislikes())
			post.setDislikes(postDTO.getDislikes());
		postService.save(post);
		return new ResponseEntity<PostDTO>(postDTO, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deletePost(@PathVariable("id") Integer id){
		Post post = postService.findOne(id);
		if (post != null) {
			postService.remove(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	

}
