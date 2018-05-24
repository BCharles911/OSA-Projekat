package com.example.demo.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.demo.entity.Comment;
import com.example.demo.entity.Post;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.entity.UserImage;

public class UserDTO implements Serializable {

    private Integer id;
    private String name;
    private String username;
    private String password;
    private String image;
    private Set<Role> role = new HashSet<>();
   // private List<Post> posts = new ArrayList<>();
    //private Set<Comment> comments = new HashSet<>();
    
	
	
	
    
    public UserDTO() {
    	
    }
    


    public UserDTO(Integer id,
    		
    		String username,
    		String name,
    		String password,
    		String image) {
    	super();
    	this.id = id;
    	this.name = username;
    	this.username = name;
    	this.password = password;
    	this.setImage(image);

    }
    
    
    public UserDTO(User user) {
    	
    	
    	this(user.getId(),
    			user.getName(),
    			user.getUsername(),
    			user.getPassword(),
    			user.getImage());
    			

    }
    
    
    
    
    
    
    
    
    
    
    
    
    public Set<Role> getRole() {
		return role;
	}



	public void setRole(Set<Role> role) {
		this.role = role;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}





	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



/*	public List<Post> getPosts() {
		return posts;
	}



	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}



	public Set<Comment> getComments() {
		return comments;
	}



	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
*/



    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	
}
