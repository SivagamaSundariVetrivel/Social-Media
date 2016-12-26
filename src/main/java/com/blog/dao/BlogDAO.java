package com.blog.dao;


import java.util.List;

import com.blog.model.Blog;

public interface BlogDAO {
 public int insertRow(Blog blog,String s);

 public List getList();

 public Blog getRowById(int id);

 public int updateRow(Blog blog/*,String path*/);

 public int deleteRow(int id);

// public int updateLikeRow(BlogLikeCount p/*,String path*/);
/* public BlogLikeCount getLikeRowById(int id);
public int updateLikeRow(BlogLikeCount p);*/
}