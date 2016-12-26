package com.blog.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Blog {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int blogId;
	@NotEmpty(message="Title cannot be EMPTY")
	private String title;
	@NotEmpty(message="Author cannot be EMPTY")
	private String author;
	@NotEmpty(message="Content cannot be EMPTY")
	private String content;
	private String tags;
	/*private int rating;
	private char like;*/
	/*private int likeItCount;*/
	private String blogcreationDate;
	
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	/*public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public int getDislikeCount() {
		return dislikeCount;
	}
	public void setDislikeCount(int dislikeCount) {
		this.dislikeCount = dislikeCount;
	}*/
	
	public String getBlogcreationDate() {
		return blogcreationDate;
	}
/*	public int getLikeItCount() {
		return likeItCount;
	}
	public void setLikeItCount(int likeItCount) {
		this.likeItCount = likeItCount;
	}
*/	public void setBlogcreationDate(String blogcreationDate) {
		this.blogcreationDate = blogcreationDate;
	}
	
}
