package com.Validator;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.Model.User;
@Component
public class UserValidator implements Validator {
	
   
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "error.userName", "user name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPassword", "error.userPassword", "password is required.");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userEmailaddress", "error.userEmailaddress", "Email is invalid.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userAddress", "error.userAddress", "Address is required.");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "usermobile", "error.usermobile", "Mobile  is required.");
		User user=(User) target;
		if(!user.getUserPassword().equals(user.getUserConformPassword()))
		{
		  errors.rejectValue("userConformPassword","userPassword.mismatch","Password do not match");
	    }
		if(!user.getUsermobile().matches("[0-9]{10}"))
		{
			errors.rejectValue("usermobile","usermobile.incorrect","Mobile no is invalid");
		}
		if(!user.getUserName().matches("[A-Za-z]+"))
		{
			errors.rejectValue("userName","userName.incorrect","user name is invalid");
		}
		if(!user.getUserEmailaddress().matches("^(.+)@(.+)$"))
		{
			errors.rejectValue("userEmailaddress","userEmailaddress.incorrect","Email id is invalid");
		}
		if(user.getUserPassword().length()>6)
		{
			errors.rejectValue("userPassword","userPassword.exceed","password should not contain more than 6 chars");
		}
	}
	

}
