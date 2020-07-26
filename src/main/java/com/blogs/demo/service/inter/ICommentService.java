package com.blogs.demo.service.inter;

import com.blogs.demo.pojo.CommentPojo;
import com.blogs.demo.pojo.common.ResponseObject;

public interface ICommentService {

	public ResponseObject addComment(CommentPojo commentPojo);
}
