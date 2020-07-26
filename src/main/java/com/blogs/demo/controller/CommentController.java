package com.blogs.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.demo.pojo.CommentPojo;
import com.blogs.demo.pojo.common.ResponseObject;
import com.blogs.demo.service.inter.ICommentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/rest")
@CrossOrigin(origins = "*")
@Slf4j
public class CommentController {

	@Autowired
	ICommentService commentService;

	@RequestMapping(value = "comments", method = RequestMethod.POST)
	public ResponseObject createPost(@RequestBody CommentPojo commentPojo) {
		ResponseObject resp = commentService.addComment(commentPojo);
		return resp;
	}
}
