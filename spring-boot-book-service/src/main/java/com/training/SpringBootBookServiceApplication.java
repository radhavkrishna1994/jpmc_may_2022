package com.training;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.training.model.Book;
import com.training.repo.BookRepo;

@SpringBootApplication
public class SpringBootBookServiceApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBookServiceApplication.class, args);
	}
	
	@Autowired
	private BookRepo bookRepo;

	/*
	 * @PostConstruct public void saveBooks() { //add some books bookRepo.save(new
	 * Book(1234l, "C", 150.25, 100l)); bookRepo.save(new Book(4567l, "CPlus",
	 * 160.25, 100l)); bookRepo.save(new Book(7643l, "Python", 170.25, 100l));
	 * bookRepo.save(new Book(9823l, "SE", 120.25, 100l)); }
	 */

	@Override
	public void run(String... args) throws Exception {
		
		/*
		 * System.out.println(bookRepo.findByTitle("C"));
		 * 
		 * System.out.println(bookRepo.findByTitleLike("%C%"));
		 * 
		 * System.out.println(bookRepo.getByStockLessThan(120l));
		 */
		
		System.out.println(bookRepo.updateStock(200l,30l));	
	}
}
