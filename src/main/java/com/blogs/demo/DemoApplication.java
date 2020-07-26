package com.blogs.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.blogs.demo.dao.ICommentRepository;
import com.blogs.demo.dao.IPostRepository;
import com.blogs.demo.model.Comment;
import com.blogs.demo.model.Post;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner mappingDemo(IPostRepository postRepository, ICommentRepository commentRepository) {
//		return args -> {
//
//			// create a new post
//			Post post = new Post.PostBuilder().setText("New Post for pet application release").setImageURL("petapp")
//					.build();
//
//			// save the post
//			postRepository.save(post);
//
//			// create and save new pages
//			commentRepository.save(new Comment( post, "Really very nice pet shop applicaton"));
//			commentRepository.save(new Comment( post, "Really useful pet shop applicaton"));
//			commentRepository.save(new Comment( post, "awesome application for booking the appointment"));
//		};
//	}
}
