package com.sumedh.storiesapi.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sumedh.storiesapi.entities.Story;
import com.sumedh.storiesapi.repositories.StoryRepository;

@Service
public class StoryService {

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	StoryRepository storyRepository;

	public Story getStoryById(int itemId) {
		String url = "https://hacker-news.firebaseio.com/v0/item/" + itemId + ".json?print=pretty";
		Story story = restTemplate.getForObject(url, Story.class);
		return story;
	}

	public Integer[] getTop500StoriesId() {
		String url = "https://hacker-news.firebaseio.com/v0/topstories.json?print=pretty";
		Integer[] top500StoriesIds = restTemplate.getForObject(url, Integer[].class);
		return top500StoriesIds;
	}

	@Cacheable("top10storiescache")
	public List<Story> getTop10Stories() {
		System.out.println("Not using Cache!!!");

		Integer[] top500StoriesIds = getTop500StoriesId();
		List<Story> top500Stories = new ArrayList<Story>();
		for (int i = 0; i < top500StoriesIds.length; i++) {
			Story story = getStoryById(top500StoriesIds[i]);
			if (story != null) {
				top500Stories.add(story);
			}
		}

		List<Story> top10Stories = top500Stories.stream().sorted(Comparator.comparing(Story::getScore).reversed())
				.limit(10).collect(Collectors.toList());

		top10Stories.stream().forEach(System.out::println);

		// Add stories to database
		saveStoriesToDatabase(top10Stories);

		return top10Stories;
	}

	public void saveStoriesToDatabase(List<Story> stories) {
		Consumer<Story> addIfNotExist = story -> {
			int id = story.getId();
			if (!storyRepository.existsById(id)) {
				storyRepository.save(story);
			}
		};

		stories.stream().forEach(addIfNotExist);
	}

}
