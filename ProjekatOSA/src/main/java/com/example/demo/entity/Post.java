package com.example.demo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.xml.stream.Location;

import com.example.demo.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="posts")
public class Post{
    
	
	
	@Id
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="post_id", unique=true, nullable=false)
	private Integer id;

    
	@Column(name="post_title",unique=false,nullable= false)
	private String title;

	
	@Column(name="post_descr",unique=false,nullable= false)
    private String description;


/*		
	@Column(name="post_avatar", unique=false, nullable = true)
    private int avatar;
	*/
	
	
	
	
	
	@Column(name="photo", unique=false, nullable=true)
	private String image;
	
	
	@Column(name = "longitude", unique= false, nullable=true)
	private Double longitude;
	
	@Column(name = "latitude", unique= false, nullable=true)
	private Double latitude;

	
	
	
	
	
	
	@ManyToOne
	@JoinColumn(name="user_id")
    private User author;
	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "date_created", unique= false, nullable= true)
    private Date date;
	

    
    @Column(name = "post_likes", unique = false, nullable = true)
    private int likes;

    
    @Column(name = "post_dislikes", unique = false, nullable = true)
    private int dislikes;
    


    @OneToMany(mappedBy = "post",cascade= CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();
	
    
    
    @PrePersist
    void preInsert() {
    	if(image == null || "".equals(image)) {
    		image = "default.png";
    	}
    }
    
    
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


	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}


	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}


	public void addComment(Comment comment) {
		comments.add(comment);
		//apdejtuj vezu sa druge strane
		comment.setPost(this);
	}
	 
	public void removeComment(Comment comment) {
	    comments.remove(comment);
	    comment.setPost(null);
	}
	
	
	
	
	
	
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "posts_tags",joinColumns = @JoinColumn(name = "post_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private Set<Tag> tags = new HashSet<>();
		
	public void addTag(Tag tag) {
        tags.add(tag);
        tag.getPosts().add(this);
    }
 
    public void removeTag(Tag tag) {
        tags.remove(tag);
        tag.getPosts().remove(this);
    }
	
	
	
	@Override
	public boolean equals(Object o) {
	     if (this == o) return true;
	     if (!(o instanceof Post )) return false;
	     return id != null && id.equals(((Post) o).id);
	}
		
		
	@Override
		public int hashCode() {
		return 31;
	}
	
	
	
	
	
	
    
    public Post() {
    	
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

    public int getPopularity() { return likes - dislikes; }


    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

/*    public Bitmap getPhoto() {
        return photo;
    }

    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }*/

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

    
    public String getImages(){
    	return image;
    }
    
    
    public void setImages(String image) {
    	this.image = image;
    }
    
    
    
/*
    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
*/
/*    public ArrayList<Comment> getComments() {
        ArrayList<Comment> retval = new ArrayList<>();
        for (Comment comment : comments) {
            if (!comment.isDeleted())
                retval.add(comment);

        }
*/


	public List<Comment> getComments() {
		return comments;
	}

    public void setComments(ArrayList<Comment> comments) {
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




    @Override
    public String toString() {
        return  "title: " + title + "\n"  +
                "description: " + description + "\n" ;
    }

	public  Set<Tag> getTags() {
		// TODO Auto-generated method stub
		return tags ;
	}
}
