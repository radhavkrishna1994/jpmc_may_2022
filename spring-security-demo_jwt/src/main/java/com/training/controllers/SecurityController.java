package com.training.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.model.UserInput;
import com.training.util.JwtUtil;

@RestController
public class SecurityController {

	@GetMapping("/hello")
	public String sayHello()
	{
		return "Hello! This is Spring Security";
	}
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authManager;
	
	
	@PostMapping("/authenticate")
	public String authenticate(@RequestBody UserInput userInput)
	{
		try {
		authManager.authenticate(new 
				UsernamePasswordAuthenticationToken(userInput.getUsername(), userInput.getPassword()));
		
		return jwtUtil.generateToken(userInput.getUsername());
		}
		catch(Exception ex)
		{
			//System.out.println(ex);
			return "Bad Credentials : "+HttpStatus.BAD_REQUEST;
		}
		
		
	}
	
	@GetMapping("/user/hello")
	public String helloUser()
	{
		return "Hello User";
	}
	
	@GetMapping("/admin/hello")
	public String helloAdmin()
	{
		return "Hello Admin";
	}
}
