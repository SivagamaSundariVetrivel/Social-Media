package com.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BlogLike {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int likeItId;
	private int blogId;
	private int userId;
	
	public int getLikeItId() {
		return likeItId;
	}
	public void setLikeItId(int likeItId) {
		this.likeItId = likeItId;
	}
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public BlogLike(int blogId) {
		super();
		this.blogId = blogId;
	}
	public BlogLike() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
