package com.blogs.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CommentPojo {

	
	private long commentId;
	private String commentText;
	private PostPojo postPojo;
	private long postId;
}
