package com.training.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	@PostMapping("/book")
	public Book saveBook(@RequestBody Book book)
	{
		return bookService.saveBook(book);
	}
	
	@ResponseStatus(HttpStatus.FOUND)
	//http://localhost:8081/bookstore/api/book/isbn/1234
	@GetMapping("/book/isbn/{isbn}")
	public Book getBook(@PathVariable("isbn") Long isbn)
	{
		return bookService.getBook(isbn);
	}
	
	@GetMapping("/book1/isbn/{isbn}")
	public ResponseEntity<Book> getBook1(@PathVariable("isbn") Long isbn)
	{
		Book book = bookService.getBook(isbn);
		return new ResponseEntity<Book>(book, HttpStatus.FOUND);
	}
	
	@DeleteMapping("/book/isbn/{isbn}")
	public Book DeleteBook(@PathVariable("isbn") Long isbn)
	{
		return bookService.deleteBook(isbn);
	}
	
	@PutMapping("/book/isbn/{isbn}/stock/{stock}")
	public Book updateBookStock(@PathVariable("isbn") Long isbn,@PathVariable("stock") Long newStock)
	{
		return bookService.updateBookStock(isbn, newStock);
	}
	
}
