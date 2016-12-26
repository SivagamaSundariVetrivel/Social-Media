package com.blog.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.blog.model.UserDetails;

@Component
public class UserValidator implements Validator {

	public boolean supports(Class<?> clazz)
	{
		return UserDetails.class.isAssignableFrom(clazz);
	}
	
	public void validate(Object obj,Errors errors) {
		UserDetails user=(UserDetails)obj;
		String password=user.getPassword();
		String confPassword=user.getReTypePass();
		 if(!password.equals(confPassword)){
	            errors.rejectValue("reTypePass","customer.password.missMatch");
	        }
	}
}
