package com.blog.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class BlogComment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cmtId;
	@NotEmpty(message="Comment cannt be EMPTY")
	private String cmtContent;
	private int blogId;
	private Date cmtDate;
	@NotEmpty(message="User Name cannt be EMPTY")
	private String userName;
	
	/*@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="userId")
	private UserDetails user;*/
	
	
	public int getCmtId() {
		return cmtId;
	}
	public Date getCmtDate() {
		return cmtDate;
	}
	public void setCmtDate(Date cmtDate) {
		this.cmtDate = cmtDate;
	}
	public void setCmtId(int cmtId) {
		this.cmtId = cmtId;
	}
	public String getCmtContent() {
		return cmtContent;
	}
	public void setCmtContent(String cmtContent) {
		this.cmtContent = cmtContent;
	}
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	/*public UserDetails getUser() {
		return user;
	}
	public void setUser(UserDetails user) {
		this.user = user;
	}*/
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}	
}
