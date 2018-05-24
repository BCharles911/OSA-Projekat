package com.example.demo.dto;

import com.example.demo.entity.UserImage;

public class UserImageDTO {
	
	private Integer id;
	
	private String title;
	
	private int width;
	
	private int height;
	
	private String contentType;
	
	private byte[] imageData;
	
	
	
	public UserImageDTO() {
		super();
	}
	
	
	
	public UserImageDTO(Integer id, String title, int width, int height,
			String contentType, byte[] imageData) {
		super();
		this.id = id;
		this.title = title;
		this.width = width;
		this.height = height;
		this.contentType = contentType;
		this.imageData = imageData;
	}
	
	
	public UserImageDTO(UserImage userImage) {
		
		this(userImage.getId(),
			userImage.getTitle(),
			userImage.getWidth(),
			userImage.getHeight(),
			userImage.getContentType(),
			userImage.getImageData());
		
		
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



	public int getWidth() {
		return width;
	}



	public void setWidth(int width) {
		this.width = width;
	}



	public int getHeight() {
		return height;
	}



	public void setHeight(int height) {
		this.height = height;
	}



	public String getContentType() {
		return contentType;
	}



	public void setContentType(String contentType) {
		this.contentType = contentType;
	}



	public byte[] getImageData() {
		return imageData;
	}



	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
	
	

}
