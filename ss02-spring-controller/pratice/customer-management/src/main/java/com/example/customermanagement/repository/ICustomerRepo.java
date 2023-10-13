package com.example.customermanagement.repository;

import com.example.customermanagement.model.Customer;

import java.util.List;

public interface ICustomerRepo {
    List<Customer> displayListCustomer();
    Customer findById(int id);
    void updateCustomer(int id,Customer customerUpdate);
}
