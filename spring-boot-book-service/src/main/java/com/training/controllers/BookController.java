package com.training.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.interfaces.BookServiceI;
import com.training.model.Book;

@RequestMapping("/bookstore/api")
@RestController
public class BookController {
	
	@Autowired
	private BookServiceI bookService;
	
	//http://localhost:8081/bookstore/api/hello
	@GetMapping("/hello")
	public String sayHello()
	{
		return "This is a Spring Boot App";
	}
	@GetMapping("/books")
	public List<Book> getBooks()
	{
		return bookService.getBooks();
	}
	
	@PostMapping("/book")
	public Book saveBook(@RequestBody Book book)
	{
		return bookService.saveBook(book);
	}
	
}
