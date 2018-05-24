package com.example.demo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.example.demo.entity.Comment;
import com.example.demo.entity.Post;
import com.example.demo.entity.Tag;
import com.example.demo.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

public class PostDTO implements Serializable {
	

	public static Set<PostDTO> convert(Set<Post> postEntitySet) {
		Set<PostDTO> postDTOSet = new HashSet<>();
		Iterator<Post> iterator = postEntitySet.iterator();
		while (iterator.hasNext()) {
			Post post = (Post) iterator.next();
			PostDTO postDTO = new PostDTO(post);
			postDTOSet.add(postDTO);
		}
		return postDTOSet;
	}
	
	
	
	
	
	
	
	private Integer id;
	private String title;
	private String description;
	private String image;
	private User author;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date date;
	private Double longitude;
	private Double latitude;
	private Set<TagDTO> tags = new HashSet<>();
	private Set<CommentDTO> comments = new HashSet<>();
	private int likes;
	private int dislikes;
	
	
	
	
	
	
	
	public String getImage() {
		return image;
	}




	public void setImage(String image) {
		this.image = image;
	}




	public Double getLongitude() {
		return longitude;
	}




	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}




	public Double getLatitude() {
		return latitude;
	}




	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	
	
	public PostDTO() {
		super();
	}
	
	
	
	
	public PostDTO(Integer id,
			String title, 
			String description,
			String image,
			User author,
			Double longitude,
			Double latitude,
			Date date,
			int likes, 
			int dislikes) {
		
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.image = image;
		this.author = author;
		this.longitude = longitude;
		this.latitude = latitude;
		this.date = date;
		this.likes = likes;
		this.dislikes = dislikes;
		
	}
	
	public PostDTO(Post post) {
		
		this(post.getId(), post.getTitle(),
				post.getDescription(),
				post.getImages(),
				post.getAuthor(),
				post.getLongitude(),
				post.getLatitude(),
				post.getDate(),
				post.getLikes(),
				post.getDislikes());
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Set<TagDTO> getTags() {
		return tags;
	}
	public void setTags(Set<TagDTO> tags) {
		this.tags = tags;
	}
	public Set<CommentDTO> getComments() {
		return comments;
	}
	public void setComments(Set<CommentDTO> comments) {
		this.comments = comments;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getDislikes() {
		return dislikes;
	}
	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}
	

}
