package com.sumedh.storiesapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sumedh.storiesapi.entities.Story;
import com.sumedh.storiesapi.repositories.StoryRepository;
import com.sumedh.storiesapi.services.StoryService;

@RestController
public class StoryController {

	@Autowired
	StoryService storySevice;
	@Autowired
	StoryRepository storyRepository;

	@GetMapping("/top-stories")
	public List<Story> top10Stories() {
		List<Story> topTenStories = storySevice.getTop10Stories();
		return topTenStories;
	}

	@GetMapping("/past-stories")
	public List<Story> pastStories() {
		return storyRepository.findAll();
	}
}
