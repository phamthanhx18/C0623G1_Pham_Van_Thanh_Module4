package com.example.formdatabinding.controller;

import com.example.formdatabinding.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class EmployeeController {
    @GetMapping
    public ModelAndView showForm() {
        return new ModelAndView("create","employee",new Employee());
    }

    @PostMapping("/addEmployee")
    public ModelAndView submit(@ModelAttribute("employee") Employee employee, ModelMap model) {
        model.addAttribute("name", employee.getName());
        model.addAttribute("contactNumber", employee.getContactNumber());
        model.addAttribute("id", employee.getId());
        return new ModelAndView("info");
    }
}
