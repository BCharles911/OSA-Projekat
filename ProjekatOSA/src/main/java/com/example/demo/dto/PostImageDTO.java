package com.example.demo.dto;

import com.example.demo.entity.PostImage;
import com.example.demo.entity.UserImage;

public class PostImageDTO {
	
	private Integer id;
	
	private String title;
	
	private int width;
	
	private int height;
	
	private String contentType;
	
	private byte[] imageData;
	
	
	public PostImageDTO() {
		super();
	}
	
	
	public PostImageDTO(Integer id, String title, int width, int height,
			String contentType, byte[] imageData) {
		super();
		this.id = id;
		this.title = title;
		this.width = width;
		this.height = height;
		this.contentType = contentType;
		this.imageData = imageData;
	}
	
	
	public PostImageDTO(PostImage postImage) {
		
		this(postImage.getId(),
				postImage.getTitle(),
				postImage.getWidth(),
				postImage.getHeight(),
				postImage.getContentType(),
				postImage.getImageData());
		
		
	}

	
	
	
	
	
	
	

}
