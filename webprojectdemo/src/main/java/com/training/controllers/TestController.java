package com.training.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	
	@ResponseBody
	@RequestMapping(value = "/hello",method = RequestMethod.GET)
	public String sayHello()   // http://localhost:8080/webprojectdemo/hello
	{
		return "Hello Spring MVC App!";
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login()   // http://localhost:8080/webprojectdemo/hello
	{
		return "login.jsp";
	}
	
	@RequestMapping(value = "/home",method = RequestMethod.GET)
	public String home(@RequestParam("username") String username,
			@RequestParam("email") String email,ModelMap map)   // http://localhost:8080/webprojectdemo/hello
	{
		
		map.addAttribute("username", username);
		map.addAttribute("email", email);
		
		return "home.jsp";
	}

}
