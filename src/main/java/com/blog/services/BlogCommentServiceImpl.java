package com.blog.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.blog.dao.BlogCommentDAO;
import com.blog.model.BlogComment;

@Service("blogCommentService")
public class BlogCommentServiceImpl implements BlogCommentService {
    
	 @Autowired
	 BlogCommentDAO blogCommentDAO;

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int insertRow(BlogComment blogComment/*,String s*/) {
	  return blogCommentDAO.insertRow(blogComment/*,s*/);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public List getList() {
	  return blogCommentDAO.getList();
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public BlogComment getRowById(int id) {
	  return blogCommentDAO.getRowById(id);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int updateRow(BlogComment blogComment/*,String path*/) {
	  return blogCommentDAO.updateRow(blogComment/*,path*/);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int deleteRow(int id) {
	  return blogCommentDAO.deleteRow(id);
	 }
}