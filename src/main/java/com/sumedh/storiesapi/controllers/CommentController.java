package com.sumedh.storiesapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sumedh.storiesapi.entities.Comment;
import com.sumedh.storiesapi.services.CommentService;

@RestController
public class CommentController {

	@Autowired
	CommentService commentService;

	@GetMapping("/comments/{itemId}")
	public List<Comment> commentsOnAPost(@PathVariable(value = "itemId") int itemId) {
		return commentService.getCommentsForAStory(itemId);
	}

}
