package com.example.customer_management_restful.repostiory;

import com.example.customer_management_restful.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {

}
