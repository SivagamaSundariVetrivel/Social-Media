package com.blog.services;


import java.util.List;

import com.blog.model.ForumReply;

public interface ForumReplyService {
 public int insertRow(ForumReply blog/*,String s*/);

 public List getList();

 public ForumReply getRowById(int id);

 public int updateRow(ForumReply blog/*,String path*/);

 public int deleteRow(int id);

}