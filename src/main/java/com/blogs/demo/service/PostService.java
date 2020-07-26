package com.blogs.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogs.demo.dao.IPostRepository;
import com.blogs.demo.model.Comment;
import com.blogs.demo.model.Post;
import com.blogs.demo.pojo.CommentPojo;
import com.blogs.demo.pojo.PostPojo;
import com.blogs.demo.pojo.common.ResponseObject;
import com.blogs.demo.service.inter.IPostService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Scope("singleton")
public class PostService implements IPostService {

	@Autowired
	IPostRepository postResp;

	@Override
	@Transactional
	public List<Post> getPost() {
		return postResp.findByShowPost("Y");
	}

	@Override
	@Transactional
	public ResponseObject addPost(PostPojo postPojo) {
		ResponseObject resp = new ResponseObject();
		try {
			Post post = new Post.PostBuilder().setText(postPojo.getText()).setImageURL(postPojo.getImageURL())
					.setShowPost("Y").setCreateAt(LocalDate.now()).build();
			
			if (postPojo.getCommentPojo() != null )
				for (CommentPojo pojo : postPojo.getCommentPojo()) {
					Comment comObj = new Comment(post, pojo.getCommentText());
					post.getComments().add(comObj);
				}
			Post po = postResp.save(post);
			postPojo.setId(po.getId());
			postPojo.setCreateAt(po.getCreateAt());
			postPojo.setShowPost(po.getShowPost());

			resp.setStatus(200);
			resp.setDescription("Success");
			resp.setMessage("Success");
			resp.setResult(postPojo);

		} catch (Exception e) {
			log.error("Exception e " + e);
			resp.setStatus(503);
			resp.setDescription(e.getMessage());
			resp.setMessage("Failure");
		}
		return resp;
	}
}
