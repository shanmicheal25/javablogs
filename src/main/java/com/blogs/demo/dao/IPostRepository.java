package com.blogs.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.blogs.demo.model.Post;

public interface IPostRepository extends CrudRepository<Post, Long>{

	 List<Post> findByShowPost(String showPost);
}
