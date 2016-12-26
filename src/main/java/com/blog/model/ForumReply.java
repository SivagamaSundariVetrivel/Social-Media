package com.blog.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class ForumReply {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int replyId;
	@NotEmpty(message="Answer cannt be EMPTY")
	private String replyContent;
	@NotEmpty(message="User Name cannt be EMPTY")
	private String username;
	private int forumId;
	private Date repliedDate;
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getForumId() {
		return forumId;
	}
	public void setForumId(int forumId) {
		this.forumId = forumId;
	}
	public Date getRepliedDate() {
		return repliedDate;
	}
	public void setRepliedDate(Date repliedDate) {
		this.repliedDate = repliedDate;
	}
	
	
	
}
