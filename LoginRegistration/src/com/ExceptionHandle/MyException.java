package com.ExceptionHandle;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class MyException{

	@ExceptionHandler(Exception.class)
	 public String m1(){
		 return "NullPointerException";
	 }

}
