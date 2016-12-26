package com.blog.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.blog.dao.ForumReplyDAO;
import com.blog.model.ForumReply;

@Service("forumReplyService")
public class ForumReplyServiceImpl implements ForumReplyService {
    
	 @Autowired
	 ForumReplyDAO forumReplyDAO;

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int insertRow(ForumReply forumReply/*,String s*/) {
	  return forumReplyDAO.insertRow(forumReply);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public List getList() {
	  return forumReplyDAO.getList();
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public ForumReply getRowById(int id) {
	  return forumReplyDAO.getRowById(id);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int updateRow(ForumReply forumReply/*,String path*/) {
	  return forumReplyDAO.updateRow(forumReply/*,path*/);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int deleteRow(int id) {
	  return forumReplyDAO.deleteRow(id);
	 }
}