package com.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.interfaces.BookServiceI;
import com.training.model.Book;
import com.training.repo.BookRepo;

@Service
public class BookService implements BookServiceI {

	@Autowired
	private BookRepo bookRepo;
	
	@Override
	public List<Book> getBooks() {
		
		return bookRepo.findAll();
	}

	@Override
	public Book getBook(Long isbn) {
		
		return null;
	}

	@Override
	public Book saveBook(Book book) {
		
		return bookRepo.save(book);
	}

	@Override
	public Book deleteBook(Long isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book updateBookStock(Long isbn, Long newStock) {
		// TODO Auto-generated method stub
		return null;
	}

}
