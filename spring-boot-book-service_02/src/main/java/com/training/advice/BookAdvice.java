package com.training.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.training.exceptions.BookNotFoundException;

@RestControllerAdvice
public class BookAdvice {

	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> InValidArgumentHandler(MethodArgumentNotValidException ex)
	{
		Map<String,String> errMap = new HashMap<>();
		ex.getBindingResult().getFieldErrors().
		forEach(error->errMap.put(error.getField(), error.getDefaultMessage()));
		
		return errMap;
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(BookNotFoundException.class)
	public String InValidBook(BookNotFoundException ex)
	{
		
		return ex.getMessage();
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String noHandlerFoundExceptionMethod(NoHandlerFoundException ex)
	{
			
		return "Path not Valid";
	}
}
