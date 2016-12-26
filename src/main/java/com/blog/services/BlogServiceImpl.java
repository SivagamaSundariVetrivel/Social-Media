package com.blog.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.blog.dao.BlogDAO;
import com.blog.model.Blog;

@Service("blogService")
public class BlogServiceImpl implements BlogService {
    
	 @Autowired
	 BlogDAO blogDAO;

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int insertRow(Blog blog,String s) {
	  return blogDAO.insertRow(blog,s);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public List getList() {
	  return blogDAO.getList();
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public Blog getRowById(int id) {
	  return blogDAO.getRowById(id);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int updateRow(Blog blog/*,String path*/) {
	  return blogDAO.updateRow(blog/*,path*/);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int deleteRow(int id) {
	  return blogDAO.deleteRow(id);
	 }
	 
	 /*@Transactional(propagation = Propagation.SUPPORTS)
	 public int updateLikeRow(BlogLikeCount p,String path)
	 {
		 return blogDAO.updateLikeRow(p);
	 }
	 
	 @Transactional(propagation = Propagation.SUPPORTS)
	 public BlogLikeCount getLikeRowById(int id)
	 {
	 return blogDAO.getLikeRowById(id);
	 }*/
}