package com.example.customermanagement.repository;

import com.example.customermanagement.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepo implements ICustomerRepo{
    private final static List<Customer> customerList;

    static {
        customerList = new ArrayList<>();
        customerList.add(new Customer(1,"Nguyen Van A","a@codegym.vn","Ha Noi"));
        customerList.add(new Customer(2,"Nguyen Van B","b@codegym.vn","Ha Noi"));
        customerList.add(new Customer(3,"Nguyen Van C","c@codegym.vn","Ha Noi"));
        customerList.add(new Customer(4,"Nguyen Van D","d@codegym.vn","Ha Noi"));
        customerList.add(new Customer(5,"Nguyen Van E","e@codegym.vn","Ha Noi"));
    }
    @Override
    public List<Customer> displayListCustomer() {
        return customerList;
    }

    @Override
    public Customer findById(int id) {
        for (Customer customer:customerList) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }
}
