package com.blogs.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.blogs.demo.dao.IPostRepository;
import com.blogs.demo.model.Post;
import com.blogs.demo.service.PostService;

import java.time.LocalDate;
import java.util.stream.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private PostService service;

	@MockBean
	private IPostRepository repository;

	@Test
	public void getPostTest() {

		when(repository.findAll()).thenReturn(Stream.of(
				new Post.PostBuilder().setText("New Post for pet application release").setImageURL("petapp").build(),
				new Post.PostBuilder().setText("New Post for shop application release").setImageURL("shopapp").build())
				.collect(Collectors.toList()));
	
		assertEquals(2, service.getPost().size());

	}

}
