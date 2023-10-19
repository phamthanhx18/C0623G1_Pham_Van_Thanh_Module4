package com.example.customermanagement.controller;

import com.example.customermanagement.model.Customer;
import com.example.customermanagement.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping
    public ModelAndView showHome(){
        return new ModelAndView("index","customers",customerService.findAll());
    }

    @GetMapping("/customer/add")
    public ModelAndView showFormAddCustomer(){
        return new ModelAndView("add","customer",new Customer());
    }

    @PostMapping("/customer/add")
    public ModelAndView saveCustomer(@ModelAttribute Customer customer){
        customerService.save(customer);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/customer/{id}/edit")
    public ModelAndView showFormEditCustomer(@PathVariable Integer id){
        Customer customer = customerService.findById(id);
        return new ModelAndView("edit","customer", customer);
    }

//    @PostMapping("/customer/{id}/edit")
//    public ModelAndView updateCustomer(@ModelAttribute Customer customer,@PathVariable Integer id){
//        customerService.updateCustomer(id,customer);
//        return new ModelAndView("edit","customer", customer);
//    }
//
//    @GetMapping("/customer/{id}/view")
//    public ModelAndView showViewCustomer(@PathVariable Integer id){
//        Customer customer = customerService.getCustomer(id);
//        return new ModelAndView("view","customer", customer);
//    }
//
//    @GetMapping("/customer/{id}/delete")
//    public ModelAndView deleteCustomer(@PathVariable Integer id){
//        customerService.deleteCustomer(id);
//        return new ModelAndView("redirect:/");
//    }
//
//    @PostMapping("/customer/search")
//    public ModelAndView showResultSearch(@RequestParam(value = "name-search") String nameSearch){
//        List<Customer> customers = customerService.searchCustomer(nameSearch);
//        return new ModelAndView("index","customers",customers);
//    }
}
