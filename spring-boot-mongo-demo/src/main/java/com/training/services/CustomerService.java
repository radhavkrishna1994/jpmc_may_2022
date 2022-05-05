package com.training.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.model.Customer;
import com.training.repo.CustomerRepo;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	public Customer saveCustomer(Customer customer)
	{
		return customerRepo.save(customer);
	}
	
	public List<Customer> getCustomers()
	{
		return customerRepo.findAll();
	}

}
