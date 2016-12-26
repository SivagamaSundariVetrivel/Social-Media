package com.blog.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.blog.model.Blog;
import com.blog.model.UserDetails;

@Component
public class BlogValidator implements Validator {

	public boolean supports(Class<?> clazz)
	{
		return Blog.class.isAssignableFrom(clazz);
	}
	
	public void validate(Object obj,Errors errors) {
		Blog blog=(Blog)obj;
		
	}
}
