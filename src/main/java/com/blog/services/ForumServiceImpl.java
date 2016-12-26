package com.blog.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.blog.dao.ForumDAO;
import com.blog.model.Forum;

@Service("forumService")
public class ForumServiceImpl implements ForumService {
    
	 @Autowired
	 ForumDAO forumDAO;

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int insertRow(Forum forum/*,String s*/) {
	  return forumDAO.insertRow(forum/*,s*/);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public List getList() {
	  return forumDAO.getList();
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public Forum getRowById(int id) {
	  return forumDAO.getRowById(id);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int updateRow(Forum forum/*,String path*/) {
	  return forumDAO.updateRow(forum/*,path*/);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int deleteRow(int id) {
	  return forumDAO.deleteRow(id);
	 }
}