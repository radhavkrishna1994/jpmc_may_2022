package com.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.training.repo.CustomerRepo;

@SpringBootApplication
public class SpringBootMongoDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongoDemoApplication.class, args);
	}

	@Autowired
	private CustomerRepo customerRepo;
	
	@Bean
	public CommandLineRunner getRunner(ApplicationContext ctx)
	{
		return args->{
			System.out.println(customerRepo.findByName("sam"));
			System.out.println(customerRepo.getByName("sam"));
			System.out.println(customerRepo.getByNameEmail("sam", "sam@gmail.com"));
		};
	}
}
