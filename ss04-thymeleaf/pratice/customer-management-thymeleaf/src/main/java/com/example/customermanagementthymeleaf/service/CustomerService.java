package com.example.customermanagementthymeleaf.service;

import com.example.customermanagementthymeleaf.model.Customer;
import com.example.customermanagementthymeleaf.repository.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService{
    @Autowired
    ICustomerRepo customerRepo;
    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepo.findById(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customerRepo.update(id,customer);
    }

    @Override
    public void remove(int id) {
        customerRepo.remove(id);
    }
}
