package com.training.feign;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.training.model.Order;

@FeignClient(name = "book-service")
@LoadBalancerClient(name = "book-service")
public interface BookFeign {
	
	@GetMapping("/bookstore/api/book/isbn/{isbn}")
	public Order createOrder(@PathVariable("isbn") Long isbn);

}
