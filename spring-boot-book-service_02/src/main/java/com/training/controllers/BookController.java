package com.training.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
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

import com.training.exceptions.BookNotFoundException;
import com.training.interfaces.BookServiceI;
import com.training.model.Book;

@Configuration
@RequestMapping("/bookstore/api")
@RestController
public class BookController {
	
	@Value("${server.port}")
	private int port;
	
	
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}

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
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/book")
	public Book saveBook(@RequestBody @Valid Book book)
	{
		
		return bookService.saveBook(book);
	}
	
	@ResponseStatus(HttpStatus.FOUND)
	//http://localhost:8081/bookstore/api/book/isbn/1234
	@GetMapping("/book/isbn/{isbn}")
	public Book getBook(@PathVariable("isbn") Long isbn) throws BookNotFoundException
	{
		System.out.println(port);
		Book book = bookService.getBook(isbn);
		book.setPort(port);
		return book;
	}
	
	/*
	 * @GetMapping("/book1/isbn/{isbn}") public ResponseEntity<Book>
	 * getBook1(@PathVariable("isbn") Long isbn) { Book book =
	 * bookService.getBook(isbn); if(book!=null) return new
	 * ResponseEntity<Book>(book, HttpStatus.FOUND); else return new
	 * ResponseEntity<Book>(book, HttpStatus.NOT_FOUND); }
	 */
	
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
