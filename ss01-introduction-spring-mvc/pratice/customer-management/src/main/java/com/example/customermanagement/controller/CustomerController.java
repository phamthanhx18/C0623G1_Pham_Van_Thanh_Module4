package com.example.customermanagement.controller;

import com.example.customermanagement.model.Customer;
import com.example.customermanagement.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    ICustomerService customerService;

    @GetMapping("/customers")
    public ModelAndView showList() {
        return new ModelAndView("index","listCustomer",customerService.displayListCustomer());
    }

    @GetMapping("/customers/info")
    public ModelAndView showInfo(int id) {
        return new ModelAndView("info","customer",customerService.findById(id));
    }
}
