package com.training;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.training.model.Book;
import com.training.repo.BookRepo;

@SpringBootApplication
public class SpringBootBookServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBookServiceApplication.class, args);
	}
	
	@Autowired
	private BookRepo bookRepo;

	@PostConstruct
	public void saveBooks()
	{
		//add some books
		bookRepo.save(new Book(1234l, "C", 150.25, 100l));
		bookRepo.save(new Book(4567l, "CPlus", 160.25, 100l));
		bookRepo.save(new Book(7643l, "Python", 170.25, 100l));
		bookRepo.save(new Book(9823l, "SE", 120.25, 100l));
	}
}
