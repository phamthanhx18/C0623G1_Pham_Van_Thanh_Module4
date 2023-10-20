package com.example.conscious.repository;

import com.example.conscious.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface ICustomerRepository extends CrudRepository<Customer, Long> {

}