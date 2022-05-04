package com.training.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.model.Book;

@RequestMapping("/bookstore/api")
@RestController
public class BookController {
	
	
	//http://localhost:8081/bookstore/api/hello
	@GetMapping("/hello")
	public String sayHello()
	{
		return "This is a Spring Boot App";
	}
	@GetMapping("/book")
	public Book getBook()
	{
		return new Book(1234l,"let us C",150.25,100l);
	}
	
}
