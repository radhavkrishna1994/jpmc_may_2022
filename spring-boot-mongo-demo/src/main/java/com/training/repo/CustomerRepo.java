package com.training.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.training.model.Customer;

@Repository
public interface CustomerRepo extends MongoRepository<Customer, Long>{

}
