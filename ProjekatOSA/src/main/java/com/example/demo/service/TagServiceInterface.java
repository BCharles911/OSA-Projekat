package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Tag;

public interface TagServiceInterface {
	
	List<Tag> findAll();
	
	
	Tag findOne(Integer tagId);
	

	Tag save(Tag tag);
	
	
	void remove(Integer id);

}
