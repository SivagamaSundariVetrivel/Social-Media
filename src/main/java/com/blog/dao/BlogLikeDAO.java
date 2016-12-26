package com.blog.dao;


import java.util.List;

import com.blog.model.BlogLike;

public interface BlogLikeDAO {
 public int insertRow(BlogLike blog/*,String s*/);

 public List getList();

 public BlogLike getRowById(int id);

 public int updateRow(BlogLike blog/*,String path*/);

 public int deleteRow(int id);

}