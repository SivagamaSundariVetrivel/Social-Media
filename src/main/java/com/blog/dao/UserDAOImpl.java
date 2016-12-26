package com.blog.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.blog.model.UserDetails;
import com.blog.model.UserRole;





@Repository("userDAO")
public class UserDAOImpl implements UserDAO{

	@Autowired
	private SessionFactory sessionFactory;

	
	@Transactional(propagation=Propagation.SUPPORTS)
	 public int insertRow(UserDetails p/*,String s*/) {
	  Session session = sessionFactory.openSession();
	  Transaction tx = session.beginTransaction();
	  p.setEnable("true");
	  p.setCreationDate(new Date());
	  //p.setImgs(s);
	 /* p.setCreationDate(s);*/
	  UserRole role=new UserRole();
	  role.setRoleId(p.getUserId());
	  role.setRoleName("ROLE_USER");
	  role.setUserName(p.getUserName());
	  session.saveOrUpdate(role);
	  session.saveOrUpdate(p);
	  tx.commit();
	  Serializable id = session.getIdentifier(p);
	  session.close();
	  return (Integer) id;
	 }

	@Transactional(propagation=Propagation.SUPPORTS)
	 public List getList() {
	  Session session = sessionFactory.openSession();
	  @SuppressWarnings("unchecked")
	  List pList = session.createQuery("from UserDetails").list();
	  session.close();
	  return pList;
	 }

	@Transactional(propagation=Propagation.SUPPORTS)
	 public UserDetails getRowById(int id) {
	  Session session = sessionFactory.openSession();
	  UserDetails p = (UserDetails) session.load(UserDetails.class, id);
	  return p;
	 }

	@Transactional(propagation=Propagation.SUPPORTS)
	 public int updateRow(UserDetails p/*,String path*/) {
	  Session session = sessionFactory.openSession();
	  Transaction tx = session.beginTransaction();
	  //p.setImgs(path);
	  session.saveOrUpdate(p);
	  tx.commit();
	  Serializable id = session.getIdentifier(p);
	  session.close();
	  return (Integer) id;
	 }

	@Transactional(propagation=Propagation.SUPPORTS)
	 public int deleteRow(int id) {
	  Session session = sessionFactory.openSession();
	  Transaction tx = session.beginTransaction();
	  UserDetails p = (UserDetails) session.load(UserDetails.class, id);
	  session.delete(p);
	  tx.commit();
	  Serializable ids = session.getIdentifier(p);
	  session.close();
	  return (Integer) ids;
	 }

	

	
}


