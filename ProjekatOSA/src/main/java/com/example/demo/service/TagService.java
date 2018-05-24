package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Tag;
import com.example.demo.repository.TagRepository;


@Service
public class TagService implements TagServiceInterface {
	
	@Autowired
	private TagRepository tagRepository;

	@Override
	public List<Tag> findAll() {
		return tagRepository.findAll();
	}

	@Override
	public Tag findOne(Integer tagId) {
		return tagRepository.getOne(tagId);
	}

	@Override
	public Tag save(Tag tag) {
		return tagRepository.save(tag);
	}

	@Override
	public void remove(Integer id) {
		tagRepository.delete(id);
		
	}

}
