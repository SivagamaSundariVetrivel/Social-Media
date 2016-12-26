package com.blog.dao;


import java.util.List;

import com.blog.model.UserDetails;





public interface UserDAO {
 public int insertRow(UserDetails user/*,String s*/);

 public List getList();

 public UserDetails getRowById(int id);

 public int updateRow(UserDetails user/*,String path*/);

 public int deleteRow(int id);

}