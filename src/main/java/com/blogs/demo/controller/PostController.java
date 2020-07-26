package com.blogs.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.demo.model.Post;
import com.blogs.demo.pojo.PostPojo;
import com.blogs.demo.pojo.common.ResponseObject;
import com.blogs.demo.service.inter.IPostService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/rest")
@CrossOrigin(origins = "*")
@Slf4j
public class PostController  {
	
	@Autowired
	IPostService postService;
	
	@RequestMapping(value = "blogs", method = RequestMethod.GET)
	public List<Post> list() {
		return postService.getPost();
	}

	@RequestMapping(value = "blogs", method = RequestMethod.POST)
	public ResponseObject createPost(@RequestBody PostPojo postPojo) {
		ResponseObject resp = postService.addPost(postPojo);
		return resp;
	}
}
