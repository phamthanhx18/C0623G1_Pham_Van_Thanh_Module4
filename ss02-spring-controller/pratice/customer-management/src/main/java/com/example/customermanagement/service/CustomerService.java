package com.example.customermanagement.service;

import com.example.customermanagement.model.Customer;
import com.example.customermanagement.repository.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService{

    @Autowired
    ICustomerRepo customerRepo;
    @Override
    public List<Customer> displayListCustomer() {
        return customerRepo.displayListCustomer();
    }

    @Override
    public Customer findById(int id) {
        return customerRepo.findById(id);
    }

    @Override
    public void updateCustomer(int id, Customer customer) {
        customerRepo.updateCustomer(id,customer);
    }
}
