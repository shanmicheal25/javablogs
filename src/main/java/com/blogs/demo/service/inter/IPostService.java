package com.blogs.demo.service.inter;

import java.util.List;

import com.blogs.demo.model.Post;
import com.blogs.demo.pojo.PostPojo;
import com.blogs.demo.pojo.common.ResponseObject;

public interface IPostService {

	public List<Post> getPost();
	
	public ResponseObject addPost(PostPojo postPojo);
}
