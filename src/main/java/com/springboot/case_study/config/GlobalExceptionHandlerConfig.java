package com.springboot.case_study.config;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springboot.case_study.exception.InvalidIdException;
import com.springboot.case_study.exception.InvalidUsernameException;



@RestControllerAdvice
public class GlobalExceptionHandlerConfig {
	
	@ExceptionHandler(InvalidIdException.class)
	public ErrorResponse invalidIDExceptionHandler(InvalidIdException e) {
		return ErrorResponse.create(e, HttpStatusCode.valueOf(400), e.getMessage());
	}
	
	 @ExceptionHandler(InvalidUsernameException.class)
 	 public ErrorResponse invalidUsernameExceptionHandler(InvalidUsernameException e) {
 		 return ErrorResponse.create
 				 			(e, 
 				 			HttpStatusCode.valueOf(400), 
 				 			e.getMessage()); 
 	 }

}
