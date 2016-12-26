package com.blog.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.blog.dao.BlogLikeDAO;
import com.blog.model.Blog;
import com.blog.model.BlogComment;
import com.blog.model.BlogLike;
import com.blog.services.BlogCommentService;
import com.blog.services.BlogLikeService;
import com.blog.services.BlogService;
import com.blog.validator.BlogValidator;
import com.blog.validator.CommentValidator;
import com.google.gson.Gson;

@Controller
public class BlogController {

	@Autowired
	BlogService blogService;
	
	@Autowired
	BlogCommentService blogCommentService;
	
	@Autowired
	BlogLikeService blogLikeService;
	
	@Autowired
	BlogValidator blogValidator;
	
	@Autowired
	CommentValidator commentValidator;
	
	public BlogController() {
		super();
		System.out.println("blog ctrl");
	}

	@RequestMapping("/addBlog")
	public String toBlog(@ModelAttribute("blo")Blog blo)
	{
		return "addBlog";
	}
	
	@RequestMapping(value="/conformBlog",method=RequestMethod.POST)
	public ModelAndView toCreateBlog(@Valid @ModelAttribute("blo")Blog blo,BindingResult bind,ModelMap m)
	{
		m.addAttribute("blo", blo);
		blogValidator.validate(blo, bind);
		if(bind.hasErrors())
		{
			return new ModelAndView("addBlog");	
		}
		else
		{
			Date d=new Date();
			SimpleDateFormat sf=new SimpleDateFormat("dd, MMM, yyyy");
			String res=sf.format(d);
			//blo.setBlogcreationDate(new Date());
			m.addAttribute("dt", res);
			blogService.insertRow(blo,res);
			blo=blogService.getRowById(blo.getBlogId());
			m.addAttribute("blog", blo);
			return new ModelAndView("conformBlogPage");	
		}
		
	}

	@RequestMapping("blogIt")
	public String blogIt(@ModelAttribute("cmt")BlogComment cmt,@RequestParam int id,Model m)
	{
		Blog blo=blogService.getRowById(id);
		m.addAttribute("blog", blo);
	return "blogPage";	
	}
	
	@RequestMapping("editBlog")
	public String toEditBlog(@ModelAttribute("blo")Blog blo,@RequestParam int id,Model m)
	{
	blo=blogService.getRowById(id);
	m.addAttribute("blog", blo);
	return "editBlog";
	}

	@RequestMapping("updateBlog")
	public String toUpdateBlog(@ModelAttribute("blo")Blog blo,@RequestParam int id,Model m)
	{
	blogService.updateRow(blo);
	//m.addAttribute("blog", blo);
	blo=blogService.getRowById(id);
	m.addAttribute("blog", blo);
	return "conformBlogPage";
	}
	
	@RequestMapping("/deleteBlog")
	public @ResponseBody ModelAndView toDeleteBlog(@ModelAttribute("blo")Blog blo,@RequestParam int id,Model m)
	{
		blogService.deleteRow(id);
		List<Blog> blogList=blogService.getList();
		Gson gson = new Gson();
		String st = gson.toJson(blogList);
		m.addAttribute("blogdata", st);
		return new ModelAndView("listBlog");
	}
	
	@RequestMapping("/listBlog")
	public @ResponseBody ModelAndView toListBlog(@ModelAttribute("blo")Blog blo,Model m)
	{
		List<Blog> blogList=blogService.getList();
		Gson gson = new Gson();
		String st = gson.toJson(blogList);
		m.addAttribute("blogdata", st);
		return new ModelAndView("listBlog");
	}
	
	@RequestMapping("/blogPage")
	public @ResponseBody ModelAndView toBlogPage(@ModelAttribute("cmt")BlogComment cmt,@RequestParam int id,Model m)
	{
		Blog blo=blogService.getRowById(id);
		int cmtCount=0;
		m.addAttribute("blog", blo);
		List<BlogComment> cmtLt=blogCommentService.getList();
		List<BlogComment> cmtNeed=new ArrayList<BlogComment>();
		for(BlogComment ccmt:cmtLt)
		{
			if(ccmt.getBlogId()==id)
			{
				cmtNeed.add(ccmt);
				cmtCount++;
			}
		}
		List<BlogLike> allLike=blogLikeService.getList();
		int likeCount=0;
		for(BlogLike like:allLike)
		{
			if(like.getBlogId()==id)
			{
			likeCount++;
			}
		}
		m.addAttribute("likeItCount", likeCount);
		/*String str=gson.toJson(cmtNeed);*/
		m.addAttribute("cmts", cmtNeed);
		m.addAttribute("count", cmtCount);
		return new ModelAndView("blogPage");
	}
	
	/*@RequestMapping("addBlogComment")
	public String toAddComment(@ModelAttribute("cmt")BlogComment cmt,@RequestParam int id,Model m)
	{
	Blog b=blogService.getRowById(id);
	m.addAttribute("blog", b);
	return "addBlogComment";
	}*/
	
	@RequestMapping(value="addComment",method=RequestMethod.POST)
	public String toAddItDb(@Valid @ModelAttribute("cmt")BlogComment cmt,BindingResult bind,@RequestParam int id,Model m)
	{
		m.addAttribute("cmt", cmt);
		commentValidator.validate(cmt, bind);
		if(!(bind.hasErrors()))
		{
		cmt.setCmtDate(new Date());
		blogCommentService.insertRow(cmt);
		}
		/*List<BlogComment> bloLt=blogCommentService.getList();
		m.addAttribute("blog", bloLt);*/
		int cmtCount=0;
		Blog blo=blogService.getRowById(id);
		m.addAttribute("blog", blo);
		List<BlogComment> cmtLt=blogCommentService.getList();
		List<BlogComment> cmtNeed=new ArrayList<BlogComment>();
		for(BlogComment ccmt:cmtLt)
		{
			if(ccmt.getBlogId()==id)
			{
				cmtNeed.add(ccmt);
				cmtCount++;
			}
		}
		List<BlogLike> allLike=blogLikeService.getList();
		int likeCount=0;
		for(BlogLike like:allLike)
		{
			if(like.getBlogId()==id)
			{
			likeCount++;
			}
		}
		m.addAttribute("likeItCount", likeCount);
		/*String str=gson.toJson(cmtNeed);*/
		m.addAttribute("cmts", cmtNeed);
		m.addAttribute("count", cmtCount);
		return "blogPage";
	}
	/*@RequestMapping("/addComment")
	public ModelAndView toAddComment(@ModelAttribute("cmt")BlogComment cmt,Model m)
	{
		blogCommentService.insertRow(cmt);
		Blog blo=blogService.getRowById(id);
		List<BlogComment> cmtLt=blogCommentService.getList();
		m.addAttribute("cmts", cmtLt);
		return new ModelAndView("blogPage","blog",blo);
	}*/
	
	@RequestMapping("/addBlogLike")
	public ModelAndView toAddALike(@ModelAttribute("cmt")BlogComment cmt,@RequestParam int id,Model m)
	{
		BlogLike newLike=new BlogLike(id);
		newLike.setBlogId(id);
		blogLikeService.insertRow(newLike);
		Blog blo=blogService.getRowById(id);
		List<BlogComment> cmtLt=blogCommentService.getList();
		List<BlogComment> cmtNeed=new ArrayList<BlogComment>();
		int cmtCount=0;
		for(BlogComment ccmt:cmtLt)
		{
			if(ccmt.getBlogId()==id)
			{
				cmtNeed.add(ccmt);
				cmtCount++;
			}
		}
		List<BlogLike> allLike=blogLikeService.getList();
		int likeCount=0;
		for(BlogLike like:allLike)
		{
			if(like.getBlogId()==id)
			{
			likeCount++;
			}
		}
		m.addAttribute("likeItCount", likeCount);
			//String str=gson.toJson(cmtNeed);
		m.addAttribute("cmts", cmtNeed);
		m.addAttribute("count", cmtCount);
		return new ModelAndView("blogPage","blog",blo);
	}
	/*
	@RequestMapping("/addDislike")
	public ModelAndView toAddADisLike(@ModelAttribute("blo")Blog blo,@RequestParam int id,Model m)
	{
		blo=blogService.getRowById(id);
		int n=blo.getDislikeCount()+1;
		blo.setDislikeCount(n);
		blogService.updateRow(blo);
		//m.addAttribute("blog",blo);
		return new ModelAndView("blogPage","blog",blo);
	}*/
}
