package com.blog.dao;


import java.util.List;

import com.blog.model.Forum;



public interface ForumDAO {
 public int insertRow(Forum forum/*,String s*/);

 public List getList();

 public Forum getRowById(int id);

 public int updateRow(Forum forum/*,String path*/);

 public int deleteRow(int id);

}