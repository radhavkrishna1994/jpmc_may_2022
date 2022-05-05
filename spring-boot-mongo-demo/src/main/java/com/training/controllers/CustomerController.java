package com.training.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.model.Customer;
import com.training.services.CustomerService;

@RestController
@RequestMapping("/customer/api")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping
	public Customer saveCustomer(@RequestBody Customer customer)
	{
		return customerService.saveCustomer(customer);
	}
	
	@GetMapping
	public List<Customer> getCustomers()
	{
		return customerService.getCustomers();
	}

}
