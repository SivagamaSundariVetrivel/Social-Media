package com.blog.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.blog.dao.BlogLikeDAO;
import com.blog.model.BlogLike;

@Service("blogLikeService")
public class BlogLikeServiceImpl implements BlogLikeService {
    
	 @Autowired
	 BlogLikeDAO blogLikeDAO;

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int insertRow(BlogLike blogLike/*,String s*/) {
	  return blogLikeDAO.insertRow(blogLike/*,s*/);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public List getList() {
	  return blogLikeDAO.getList();
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public BlogLike getRowById(int id) {
	  return blogLikeDAO.getRowById(id);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int updateRow(BlogLike blogLike/*,String path*/) {
	  return blogLikeDAO.updateRow(blogLike/*,path*/);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int deleteRow(int id) {
	  return blogLikeDAO.deleteRow(id);
	 }
}