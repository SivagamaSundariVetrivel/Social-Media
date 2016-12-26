package com.blog.services;


import java.util.List;

import com.blog.model.BlogComment;

public interface BlogCommentService {
 public int insertRow(BlogComment blog/*,String s*/);

 public List getList();

 public BlogComment getRowById(int id);

 public int updateRow(BlogComment blog/*,String path*/);

 public int deleteRow(int id);

}