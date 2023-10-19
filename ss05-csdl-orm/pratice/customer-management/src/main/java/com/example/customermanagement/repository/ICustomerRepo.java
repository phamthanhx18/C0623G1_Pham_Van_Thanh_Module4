package com.example.customermanagement.repository;

import com.example.customermanagement.model.Customer;

import java.util.List;

public interface ICustomerRepo {
    List<Customer> findAll();
    Customer findById(int id);
    void save(Customer customer);
}
