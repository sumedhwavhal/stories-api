package com.sumedh.storiesapi.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sumedh.storiesapi.entities.Comment;
import com.sumedh.storiesapi.entities.Story;

@Service
public class CommentService {

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	StoryService storyService;

	public int[] getCommentIds(int itemId) {
		Story story = storyService.getStoryById(itemId);
		int[] commentIds = null;
		if (story.getKids() != null) {
			commentIds = story.getKids();
		}
		return commentIds;
	}

	public Comment getCommentById(int itemId) {
		String url = "https://hacker-news.firebaseio.com/v0/item/" + itemId + ".json?print=pretty";
		Comment comment = restTemplate.getForObject(url, Comment.class);
		return comment;
	}

	@Cacheable("top10commentscache")
	public List<Comment> getCommentsForAStory(int itemId) {
		System.out.println("Not using cache!!");
		int[] commentIds = getCommentIds(itemId);
		List<Comment> comments = new ArrayList<Comment>();
		for (int i = 0; i < commentIds.length; i++) {
			Comment comment = getCommentById(commentIds[i]);
			if (comment != null) {
				comments.add(comment);
			}
		}

		Function<Comment, Integer> numberOfChildComments = (comment) -> {
			if (comment.getKids() != null) {
				// System.out.println(comment.getBy()+" : "+ comment.getKids().length);
				return Integer.valueOf(comment.getKids().length);
			}
			return 0;
		};

		List<Comment> top10Comments = comments.stream().sorted(Comparator.comparing(numberOfChildComments).reversed())
				.limit(10).collect(Collectors.toList());

		top10Comments.stream().forEach(System.out::println);

		return top10Comments;
	}

	/*
	 * @CacheEvict(value = "top10commentscache", allEntries = true)
	 * 
	 * @Scheduled(fixedRateString = "${caching.spring.cacheTTL}") public void
	 * emptyTop10CommentsCache() {
	 * System.out.println("Emptying top10commentscache"); }
	 */

}
