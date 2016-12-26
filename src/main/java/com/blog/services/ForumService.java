package com.blog.services;


import java.util.List;

import com.blog.model.Forum;

public interface ForumService {
 public int insertRow(Forum f/*,String s*/);

 public List getList();

 public Forum getRowById(int id);

 public int updateRow(Forum f/*,String path*/);

 public int deleteRow(int id);

}