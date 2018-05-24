package com.example.demo.entity;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class User implements Serializable{
	
	public User() {
		
	}

	
	

    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column(name="user_id", unique=true, nullable=false)
    private Integer id;
    
    
    
    
    @Column(name="name_user", unique=false, nullable=false)
    private String name;

    
    @Column(name="username", unique=true, nullable=false)
    private String username;
    
    @Column(name="password", unique=false, nullable=false)
    private String password;
    
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name= "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    
    public Set<Role> getRoles() {
		return roles;
	}








	public void setRole(Set<Role> roles) {
		this.roles = roles;
	}

	//@OneToMany(cascade= {ALL}, fetch=LAZY, mappedBy="user")
    private ArrayList<Post> posts = new ArrayList<>();
    
    
    
   @OneToMany(cascade= CascadeType.ALL, fetch=FetchType.EAGER)
   @JoinTable(name = "comment_users", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name="comment_id"))
   private Set<Comment> comments = new HashSet<>();
    
    
    @Column(name="image", unique=false, nullable=false)
    private String image;
    

    
    public String getImage() {
		return image;
	}








	public void setImages(String image) {
		this.image = image;
	}








	public void add(Comment comment) {
    	if(comment.getAuthor() != null)
    		comment.getAuthor().getPosts().remove(comment);
    	comment.setAuthor(this);
    	getComments().add(comment);
    }
    
    
    
/*	public void add(UserImage image) {
		if(image.getUser() != null)
			image.getUser().getImage().remove(image);
		image.setUser(this);
		getImage().add(image);
	}
    
    */
    
    
    
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

  /*  public Bitmap getPhoto() {
        return photo;
    }

    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }
*/
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

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

 
}
