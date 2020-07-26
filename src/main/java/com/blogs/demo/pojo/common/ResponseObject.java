package com.blogs.demo.pojo.common;

import lombok.Data;

@Data
public class ResponseObject {
	private int status;
	private String message;
	private String description;
	private Object result;
	
}
