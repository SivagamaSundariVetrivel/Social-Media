package com.blog.services;


import java.util.List;

import com.blog.model.BlogLike;

public interface BlogLikeService {
 public int insertRow(BlogLike blog/*,String s*/);

 public List getList();

 public BlogLike getRowById(int id);

 public int updateRow(BlogLike blog/*,String path*/);

 public int deleteRow(int id);

}