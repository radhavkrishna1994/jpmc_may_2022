package com.training.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.model.UserInput;
import com.training.util.JwtUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class SecurityController {
	
	@GetMapping("/hello")
	public String sayHello()
	{
		return "Hello Security App";
	}
	
	@GetMapping("/user/hello")
	public String sayHelloUser()
	{
		return "Hello User";
	}
	
	@GetMapping("/admin/hello")
	public String sayAdminUser()
	{
		return "Hello Admin";
	}
	
	@Autowired
	private AuthenticationManager authManger;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("/authenticate") 
	public String authenticate(@RequestBody UserInput userInput)
	{
		
		log.info("Inside Authenticate");
		try {
		authManger.authenticate(new UsernamePasswordAuthenticationToken
				(userInput.getUsername(), userInput.getPassword()));
		return jwtUtil.generateToken(userInput.getUsername());
		
		}
		catch(Exception ex)
		{
			log.info(ex.toString());
			return "User Credentials Not Right";
		}
		
		
		
	}

}
