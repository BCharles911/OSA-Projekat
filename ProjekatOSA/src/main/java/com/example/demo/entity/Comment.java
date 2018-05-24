package com.example.demo.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.xml.stream.Location;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Lob;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;



@Entity
@Table(name="comments")
public class Comment {
    
	
	
	
	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="comment_id", unique=true, nullable=false)
	private Integer id;
	
	
	@Column(name="comment_title", unique=false,nullable= false)
    private String title;
	
	@Column(name="comment_description", unique=false,nullable= false)
    private String description;
	
	@ManyToOne
	@JoinColumn(name="user_id")
    private User author;
	
	@Column(name="comment_date", unique=false,nullable= false)
    private Date date;
	
	
	
	@ManyToOne
	@JoinColumn(name="post_id")
    private Post post;
	
	@Column(name="likes", unique=false,nullable= false)
    private int likes;
    
    
	@Column(name="dislikes", unique=false,nullable= false)
    private int dislikes;
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment )) return false;
        return id != null && id.equals(((Comment) o).id);
    }
	
    @Override
    public int hashCode() {
        return 31;
    }
	
    private boolean deleted;


    public Comment() {

    }

    public Comment(String title, String description, Date date, int likes, int dislikes){
        this.title = title;
        this.description = description;
        this.date = date;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
    // private AsyncTask.Status status;



    public int getPopularity(){
        return likes - dislikes;
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
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

	public User getUser() {
		// TODO Auto-generated method stub
		return author;
	}

  //  public Status getStatus() {
  //      return status;
  //  }

  //  public void setStatus(Status status) {
  //      this.status = status;
  //  }
}
