package com.blog.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.blog.dao.UserDAO;
import com.blog.model.UserDetails;





@Service("userService")
public class UserServiceImpl implements UserService {
    
	 @Autowired
	 UserDAO userDAO;

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int insertRow(UserDetails user/*,String s*/) {
	  return userDAO.insertRow(user/*,s*/);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public List getList() {
	  return userDAO.getList();
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public UserDetails getRowById(int id) {
	  return userDAO.getRowById(id);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int updateRow(UserDetails user/*,String path*/) {
	  return userDAO.updateRow(user/*,path*/);
	 }

	 @Transactional(propagation = Propagation.SUPPORTS)
	 public int deleteRow(int id) {
	  return userDAO.deleteRow(id);
	 }
}