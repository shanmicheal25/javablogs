package com.blogs.demo.pojo;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class PostPojo {
	
	private long id;
	private String text;
	private String imageURL;
	private LocalDate createAt;
	private String showPost;
	private List<CommentPojo> commentPojo;
}
