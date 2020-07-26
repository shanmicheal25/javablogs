package com.blogs.demo.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogs.demo.dao.ICommentRepository;
import com.blogs.demo.dao.IPostRepository;
import com.blogs.demo.model.Comment;
import com.blogs.demo.model.Post;
import com.blogs.demo.pojo.CommentPojo;
import com.blogs.demo.pojo.PostPojo;
import com.blogs.demo.pojo.common.ResponseObject;
import com.blogs.demo.service.inter.ICommentService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Scope("prototype")
public class CommentService implements ICommentService {

	@Autowired
	ICommentRepository commentResp;
	
	@Autowired
	IPostRepository postResp;
	
	@Override
	@Transactional
	public ResponseObject addComment(CommentPojo commentPojo) {
		ResponseObject resp = new ResponseObject();
		try {
		
			Comment comObj =  null;
			if(commentPojo.getPostPojo() == null) {
				Optional<Post> post = postResp.findById(commentPojo.getPostId());
				comObj = new Comment(post.get(), commentPojo.getCommentText());
				
			}else {
				
			}
			
			commentResp.save(comObj);
			commentPojo.setCommentId(comObj.getCommentId());
			resp.setStatus(200);
			resp.setDescription("Success");
			resp.setMessage("Success");
			resp.setResult(commentPojo);

		} catch (Exception e) {
			log.error("Exception e " + e);
			resp.setStatus(503);
			resp.setDescription(e.getMessage());
			resp.setMessage("Failure");
		}
		return resp;
	}
}
