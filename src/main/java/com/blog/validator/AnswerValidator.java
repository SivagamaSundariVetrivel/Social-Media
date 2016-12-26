package com.blog.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.blog.model.ForumReply;

@Component
public class AnswerValidator implements Validator {

	public boolean supports(Class<?> clazz)
	{
		return ForumReply.class.isAssignableFrom(clazz);
	}
	
	public void validate(Object obj,Errors errors) {
		ForumReply cmt=(ForumReply)obj;
		
	}
}
