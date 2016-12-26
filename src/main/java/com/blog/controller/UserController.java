package com.blog.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.blog.model.UserDetails;
import com.blog.services.UserService;
import com.blog.validator.UserValidator;

@Controller
public class UserController {

	@Autowired
	UserService userService;
		
	@Autowired
	UserValidator userValidator;
	
	public UserController() {
		super();
		System.out.println("user ctrl");
	}

	@RequestMapping("/login")
	public String gotologin(@RequestParam(value="error",required = false) String error, @RequestParam(value="logout",required = false) String logout, Model model) 
	{
		
		if(error!=null)
		{
			model.addAttribute("error","Invalid username or password!");
		}
		if(logout!=null)
		{
			model.addAttribute("msg", "You have logged out successfully...");
		}
		return  "login";
  	}
	
	@RequestMapping("/signUp")
	public String toRegister(@ModelAttribute("usr")UserDetails usr)
	{
		return "signUp";
	}
	
	/*@RequestMapping("/profile")
	public String toUserProfile(@ModelAttribute("usr")UserDetails usr)
	{
		return "profile";
	}
*/
	@RequestMapping(value="/joinUs",method=RequestMethod.POST)
	public String registerIt(@Valid @ModelAttribute("usr")UserDetails usr,BindingResult bind,Model m,HttpServletRequest req)
	{
		
		m.addAttribute("usr", usr);
		userValidator.validate(usr, bind);
		String name=req.getParameter("userName");
		String mail=req.getParameter("email");
		String pass=req.getParameter("password");
		String cnpas=req.getParameter("reTypePass");
		if(!(pass.equals(cnpas)))
		{
			m.addAttribute("reTypePassError", "Password doesnt match..");
		}
		for(char c : name.toCharArray()){
	        if(Character.isDigit(c)){  
	        	m.addAttribute("erruser","userName is invalid.. (can't contain integer)");
	        	return "signUp";  
	        } 
 	 }
	
	 List<UserDetails> users=userService.getList();
	 for(UserDetails user:users)
	 {
		 if(user.getUserName().equals(name))
		 {
			 m.addAttribute("erruser","User Name already exists..");
			 return "signUp";
		 }
		 if(user.getEmail().equals(mail))
		 {
			 m.addAttribute("errmail","EmailID already exists..");
			 return "signUp";
		 }
	 }
		if(bind.hasErrors())
		{
			return "signUp";
		}
		else
		{
			usr.setCreationDate(new Date());
			userService.insertRow(usr);
			return "index";
		}
	}
	/*@RequestMapping(value="/joinUs",method=RequestMethod.POST)
	public ModelAndView registerIt(HttpServletRequest req)
	{
		String name=req.getParameter("userName");
		String mail=req.getParameter("email");
		String pwd=req.getParameter("password");
		String cpwd=req.getParameter("reTypePass");
		
		//to find if username contains numbers
		for(char c : name.toCharArray()){
		        if(Character.isDigit(c)){  
		        	return new ModelAndView("signUp","erruser","userName is invalid.. (can't contain integer)");  
		        } 
	 	 }
		
		 List<UserDetails> users=userService.getList();
		 for(UserDetails user:users)
		 {
			 if(user.getUserName().equals(name))
			 {
				 return new ModelAndView("signUp","erruser","User Name already exists..");
			 }
			 if(user.getEmail().equals(mail))
			 {
				 return new ModelAndView("signUp","errmail","EmailID already exists..");
			 }
		 }
		 
		//check if the password matches
		 if(!(pwd.equals(cpwd)))
		 	{
				return new ModelAndView("signUp","err","Password doesnt match..");
			}
		 
		 if((name.isEmpty())&&(mail.isEmpty())&&(pwd.isEmpty()))
		 {
			 return new ModelAndView("signUp","err","All the fields must be filled..");
		 } 
		 else{
			 UserDetails usr=new UserDetails();
			 usr.setUserName(name);
			 usr.setEmail(mail);
			 usr.setPassword(pwd);
			 Date date=new Date();
			 usr.setCreationDate(date);
			 usr.setEnable(1);
			 userService.insertRow(usr);
			return new ModelAndView("index");
		 }
	}*/
	
	/*@RequestMapping("login")
	public String toLogin()
	{
		return "login";
	}*/
}
