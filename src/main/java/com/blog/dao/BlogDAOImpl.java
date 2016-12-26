package com.blog.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.blog.model.Blog;

@Repository("blogDAO")
public class BlogDAOImpl implements BlogDAO{

	@Autowired
	private SessionFactory sessionFactory;

	
	@Transactional(propagation=Propagation.SUPPORTS)
	 public int insertRow(Blog p,String s) {
	  Session session = sessionFactory.openSession();
	  Transaction tx = session.beginTransaction();
	  //p.setImgs(s);
	  session.saveOrUpdate(p);
	  /*BlogLikeCount likeCount=new BlogLikeCount();
	  likeCount.setBlogLikeCountId(p.getBlogId());
	  p.setBlogcreationDate(s);
	  session.saveOrUpdate(likeCount);*/
	  tx.commit();
	  Serializable id = session.getIdentifier(p);
	  session.close();
	  return (Integer) id;
	 }

	@Transactional(propagation=Propagation.SUPPORTS)
	 public List getList() {
	  Session session = sessionFactory.openSession();
	  @SuppressWarnings("unchecked")
	  List pList = session.createQuery("from Blog").list();
	  session.close();
	  return pList;
	 }

	@Transactional(propagation=Propagation.SUPPORTS)
	 public Blog getRowById(int id) {
	  Session session = sessionFactory.openSession();
	  Blog p = (Blog) session.load(Blog.class, id);
	  return p;
	 }
	
	@Transactional(propagation=Propagation.SUPPORTS)
	 public int updateRow(Blog p/*,String path*/) {
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
	  Blog p = (Blog) session.load(Blog.class, id);
	  session.delete(p);
	  tx.commit();
	  Serializable ids = session.getIdentifier(p);
	  session.close();
	  return (Integer) ids;
	 }

	/*@Transactional(propagation=Propagation.SUPPORTS)
	 public int updateLikeRow(BlogLikeCount p,String path) {
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
	 public BlogLikeCount getLikeRowById(int id) {
	  Session session = sessionFactory.openSession();
	  BlogLikeCount p = (BlogLikeCount) session.load(BlogLikeCount.class, id);
	  return p;
	 }*/

}
