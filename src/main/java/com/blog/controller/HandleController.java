package com.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HandleController {

	public HandleController() {
		super();
		System.out.println("handle ctrl");
	}
	
	@RequestMapping("/")
	public String toRoot()
	{
		return "page1";
	}
	
	@RequestMapping("/page1")
	public String toIndex()
	{
		return "page1";
	}
}
