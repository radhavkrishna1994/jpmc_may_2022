package com.training.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.model.Order;
import com.training.services.JmsService;

@RestController
public class JmsController {

	@Autowired
	private JmsService jmsService;
	
	@GetMapping("/message/{message}")
	public String publishMessage(@PathVariable("message") String message)
	{
		return jmsService.publishMessage(message);
	}
	
	@PostMapping("/order")
	public String publishOrder(@RequestBody Order order)
	{
		return jmsService.publishOrder(order);
	}
	

	@PostMapping("/orders")
	public String publishOrders(@RequestBody List<Order> orders)
	{
		return jmsService.publishOrders(orders);
	}
}
