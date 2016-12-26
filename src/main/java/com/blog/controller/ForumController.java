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

import com.blog.model.Blog;
import com.blog.model.BlogComment;
import com.blog.model.Forum;
import com.blog.model.ForumReply;
import com.blog.services.ForumReplyService;
import com.blog.services.ForumService;
import com.blog.validator.AnswerValidator;
import com.blog.validator.ForumValidator;
import com.google.gson.Gson;



@Controller
public class ForumController {

	@Autowired
	ForumService forumService;
	
	@Autowired
	ForumReplyService forumReplyService;
	
	@Autowired
	ForumValidator forumValidator;
	
	@Autowired
	AnswerValidator answerValidation;
	
	public ForumController() {
		super();
		System.out.println("forum ctrl");
	}

	@RequestMapping("/addForum")
	public String toForum(@ModelAttribute("frm")Forum frm)
	{
		return "addForum";
	}

/*	@RequestMapping(value="/conformForumPage",method=RequestMethod.POST)
	public ModelAndView toConformForum(@ModelAttribute("frm")Forum frm,@RequestParam int id)
	{
		frm=forumService.getRowById(id);
		return new ModelAndView("conformForumPage","forum",frm);
	}
*/
	@RequestMapping(value="/conformForumPage",method=RequestMethod.POST)
	public ModelAndView toCreateBlog(@Valid @ModelAttribute("frm")Forum frm,BindingResult bind,ModelMap m)
	{
		m.addAttribute("frm", frm);
		forumValidator.validate(frm, bind);
		/*Date d=new Date();
		SimpleDateFormat sf=new SimpleDateFormat("dd/MM/yyyy");
		String res=sf.format(d);
		//blo.setBlogcreationDate(new Date());
		m.addAttribute("dt", res);*/
		if(bind.hasErrors())
		{
			return new ModelAndView("addForum");
		}
		else
		{
			frm.setCreationDate(new Date());
			frm.setReplyCount(0);
			forumService.insertRow(frm);
			frm=forumService.getRowById(frm.getForumId());
			m.addAttribute("forum", frm);
			return new ModelAndView("conformForumPage");
		}

		
	}

	
	@RequestMapping(value="/postIt",method=RequestMethod.POST)
	public ModelAndView toCreateForum(@ModelAttribute("frm")Forum frm)
	{
		frm.setCreationDate(new Date());
		forumService.insertRow(frm);
		return new ModelAndView("forumPage");
	}
	
	@RequestMapping("/listForum")
	public ModelAndView toListForum(@ModelAttribute("frm")Forum frm,Model m)
	{
		List<Forum> forumList=forumService.getList();
		Gson gson=new Gson();
		String flt=gson.toJson(forumList);
		m.addAttribute("forumdata", flt);
		return new ModelAndView("listForum","forumLt",forumList);
	}
	
	@RequestMapping("editForum")
	public String toEditForum(@ModelAttribute("frm")Forum frm,@RequestParam int id,Model m)
	{
	frm=forumService.getRowById(id);
	m.addAttribute("forum", frm);
	return "editForum";
	}

	@RequestMapping("updateForum")
	public String toUpdateForum(@ModelAttribute("frm")Forum frm,@RequestParam int id,Model m)
	{
		forumService.updateRow(frm);
	//m.addAttribute("blog", blo);
	frm=forumService.getRowById(id);
	m.addAttribute("forum", frm);
	return "conformForumPage";
	}
	
	@RequestMapping("/deleteForum")
	public @ResponseBody ModelAndView toDeleteForum(@ModelAttribute("frm")Forum frm,@RequestParam int id,Model m)
	{
		forumService.deleteRow(id);
		List<Blog> blogList=forumService.getList();
		Gson gson = new Gson();
		String st = gson.toJson(blogList);
		m.addAttribute("forumdata", st);
		return new ModelAndView("listForum");
	}
	
	@RequestMapping("/forumPage")
	public ModelAndView toForumPage(@ModelAttribute("reply")ForumReply reply,@RequestParam int id,Model m)
	{ 
		Forum frm=forumService.getRowById(id);
		m.addAttribute("forum",frm);
		List<ForumReply> ansLt=forumReplyService.getList();
		List<ForumReply> replyNeed=new ArrayList<ForumReply>();
		int solCount=0;
		for(ForumReply rply:ansLt)
		{
			if(rply.getForumId()==id)
			{
				replyNeed.add(rply);
				solCount++;
			}
		}
		/*String str=gson.toJson(cmtNeed);*/
		m.addAttribute("replies", replyNeed);
		m.addAttribute("replyCount", solCount);
		return new ModelAndView("forumPage");
	}
	
	@RequestMapping(value="addAnswer",method=RequestMethod.POST)
	public String toAddAnsDb(@Valid @ModelAttribute("reply")ForumReply reply,BindingResult bind,@RequestParam int id,Model m)
	{
		m.addAttribute("reply", reply);
		answerValidation.validate(reply,bind);
		if(!(bind.hasErrors()))
		{
		reply.setRepliedDate(new Date());
		forumReplyService.insertRow(reply);
		}
		/*List<BlogComment> bloLt=blogCommentService.getList();
		m.addAttribute("blog", bloLt);*/
		Forum frm=forumService.getRowById(id);
		m.addAttribute("forum", frm);
		List<ForumReply> replyLt=forumReplyService.getList();
		List<ForumReply> replyNeed=new ArrayList<ForumReply>();
		int solCount=0;
		for(ForumReply creply:replyLt)
		{
			if(creply.getForumId()==id)
			{
				replyNeed.add(creply);
				solCount++;
			}
		}
		m.addAttribute("replies", replyNeed);
		m.addAttribute("replyCount", solCount);
		return "forumPage";
	}
	
	
	/*	@RequestMapping("/addLike")
	public ModelAndView toAddALike(@ModelAttribute("frm")Forum frm,@RequestParam int id,Model m)
	{
		frm=forumService.getRowById(id);
		int n=frm.getLikeCount()+1;
		frm.setLikeCount(n);
		forumService.updateRow(frm);
		//m.addAttribute();
		return new ModelAndView("forumPage","forum",frm);
	}
	
	@RequestMapping("/addDislike")
	public ModelAndView toAddADisLike(@ModelAttribute("frm")Forum frm,@RequestParam int id,Model m)
	{
		frm=forumService.getRowById(id);
		int n=frm.getDislikeCount()+1;
		frm.setDislikeCount(n);
		forumService.updateRow(frm);
		//m.addAttribute("forum",frm);
		return new ModelAndView("forumPage","forum",frm);
	}*/
}
