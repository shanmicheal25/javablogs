package com.blogs.demo.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import com.blogs.demo.model.Comment;
import com.blogs.demo.model.Post;

public interface ICommentRepository extends CrudRepository<Comment, Long>{

	
	 List<Comment> findByPost(Post post, Sort sort);
}
