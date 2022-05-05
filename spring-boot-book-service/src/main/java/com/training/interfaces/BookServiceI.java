package com.training.interfaces;

import java.util.List;

import com.training.exceptions.BookNotFoundException;
import com.training.model.Book;

public interface BookServiceI {

	// get  all books
	public List<Book> getBooks();
	
	// get a book
	public Book getBook(Long isbn) throws BookNotFoundException;
	
	//save a book
	public Book saveBook(Book book);
	
	//delete a book
	public Book deleteBook(Long isbn);
	
	//update stock of the book
	public Book updateBookStock(Long isbn,Long newStock);
	
	
}
