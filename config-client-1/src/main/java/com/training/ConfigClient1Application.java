package com.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.config.MyConfiguration;


@RestController
@SpringBootApplication
public class ConfigClient1Application {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClient1Application.class, args);
	}
	@Autowired
	private MyConfiguration config;
	
	@GetMapping("/message")
	public String printMessage()
	{
		return config.getMessage();
	}

}
