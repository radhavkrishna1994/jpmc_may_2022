package com.training.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/bookstore/api")
@RestController
public class BookController {
	
	
	//http://localhost:8081/bookstore/api/hello
	@GetMapping("/hello")
	public String sayHello()
	{
		return "This is a Spring Boot App";
	}

}
