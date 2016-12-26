package com.blog.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.blog.model.Forum;
import com.blog.model.UserDetails;

@Component
public class ForumValidator implements Validator {

	public boolean supports(Class<?> clazz)
	{
		return Forum.class.isAssignableFrom(clazz);
	}
	
	public void validate(Object obj,Errors errors) {
		Forum blog=(Forum)obj;
		
	}
}
