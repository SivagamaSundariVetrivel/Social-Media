package com.blog.controller;

import java.util.Date;

import org.springframework.messaging.handler.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.blog.dto.*;

@Controller
public class ChatController {

	
  public ChatController() {
		super();
		System.out.println("chat here..");
		// TODO Auto-generated constructor stub
	}

@RequestMapping(value="/index",method=RequestMethod.GET)
  public String viewApplication() {
    return "index";
  }

  @MessageMapping("/chat")
  @SendTo("/topic/message")
  public OutputMessage sendMessage(Message message) {
    return new OutputMessage(message, new Date());
  }
}