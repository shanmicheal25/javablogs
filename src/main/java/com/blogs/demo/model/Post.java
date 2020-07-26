package com.blogs.demo.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "posts")
@NamedQuery(name = "Post.findAll", query = "SELECT p FROM Post p")
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private long id;

	@Column(name = "text", length = 5000)
	private String text;

	@Column(name = "imageURL", length = 255)
	private String imageURL;

	@Column(name = "createAt")
	private LocalDate createAt;

	@Column(name = "showPost", length = 1)
	private String showPost;
	
	@OneToMany(mappedBy = "post", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<Comment> comments;

	private Post(PostBuilder builder) {
		this.text = builder.text;
		this.imageURL = builder.imageURL;
		this.createAt = builder.createAt;
		this.showPost = builder.showPost;
	}

	public Post(String text, String imageURL, LocalDate createAt, String showPost) {
		super();
		this.text = text;
		this.imageURL = imageURL;
		this.createAt = createAt;
		this.showPost = showPost;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", text=" + text + ", imageURL=" + imageURL + ", createAt=" + createAt + ", showPost="
				+ showPost + ", comments=" + comments + "]";
	}

	public static class PostBuilder {
		private String text;
		private String imageURL;
		private LocalDate createAt;
		private String showPost;
		
		public PostBuilder setText(String text) {
			this.text = text;
			return this;
		}
		public PostBuilder setImageURL(String imageURL) {
			this.imageURL = imageURL;
			return this;
		}
		public PostBuilder setCreateAt(LocalDate createAt) {
			this.createAt = createAt;
			return this;
		}
		public PostBuilder setShowPost(String showPost) {
			this.showPost = showPost;
			return this;
		}
		 public Post build() {
			 Post post =  new Post(this);
	         return post;
	     }
	}


}
