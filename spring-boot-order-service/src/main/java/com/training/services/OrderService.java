package com.training.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.training.feign.BookFeign;
import com.training.model.Order;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@Service
public class OrderService {

	//http://localhost:8081/bookstore/api/book/isbn/1234
	private String producerUrl = "http://localhost:8081/bookstore/api/book/isbn/{isbn}";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@CircuitBreaker(name = "instanceA",fallbackMethod = "defaultFallBack")
	public Order createOrder(Long isbn,int qty)
	{
		Map<String,String> map = new HashMap<>();
		map.put("isbn", String.valueOf(isbn));
		
		Order order = restTemplate.getForObject(producerUrl, Order.class, map);
		
		order.setQty(qty);
		order.setAmount(order.getPrice() * qty );
		
		return order;
	}
	
	public Order defaultFallBack(Exception e)
	{
		return new Order(0l, "Fault in the book retrieval", 0.0, null, 0, null, 0);
	}
	
	@Autowired
	private BookFeign bookFeign;
	
	public Order createOrderFeign(Long isbn,int qty)
	{
		
		Order order = bookFeign.createOrder(isbn);
		order.setQty(qty);
		order.setAmount(order.getPrice() * qty );
		
		return order;
	}
	
}
