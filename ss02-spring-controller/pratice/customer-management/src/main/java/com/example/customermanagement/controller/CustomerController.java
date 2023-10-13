package com.example.customermanagement.controller;

import com.example.customermanagement.model.Customer;
import com.example.customermanagement.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping
public class CustomerController {

    @Autowired
    ICustomerService customerService;

    @GetMapping("/customers")
    public ModelAndView showList() {
        return new ModelAndView("index","listCustomer",customerService.displayListCustomer());
    }

    @GetMapping("/customers/{id}")
    public ModelAndView showInfo(@PathVariable int id) {
        return new ModelAndView("info","customer",customerService.findById(id));
    }

    @PostMapping("/update/{idUpdate}")
    public ModelAndView updateCustomer(@RequestParam int id, String name, String email, String address, @PathVariable int idUpdate) {
        customerService.updateCustomer(idUpdate, new Customer(id, name, email, address));
        return showList();
    }
}
