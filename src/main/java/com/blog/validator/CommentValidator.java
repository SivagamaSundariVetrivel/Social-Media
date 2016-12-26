package com.blog.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.blog.model.BlogComment;

@Component
public class CommentValidator implements Validator {

	public boolean supports(Class<?> clazz)
	{
		return BlogComment.class.isAssignableFrom(clazz);
	}
	
	public void validate(Object obj,Errors errors) {
		BlogComment cmt=(BlogComment)obj;
		
	}
}
