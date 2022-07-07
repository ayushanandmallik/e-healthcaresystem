package com.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.entities.Users;

public class UserValidation implements Validator{

	
	public boolean supports(Class<?>arg0) {
		return Users.class.equals(arg0);
	}
	
	public void validate(Object arg0, Errors e) {
//		ValidationUtils.rejectIfEmpty(e, "name", "name.empty");
		ValidationUtils.rejectIfEmpty(e, "email", "email.empty");
		ValidationUtils.rejectIfEmpty(e, "password", "password.empty");
		//ValidationUtils.rejectIfEmpty(e, "role", "role.empty");
	}


}
