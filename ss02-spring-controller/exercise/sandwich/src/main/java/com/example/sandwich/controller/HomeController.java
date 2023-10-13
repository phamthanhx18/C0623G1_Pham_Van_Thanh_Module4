package com.example.sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class HomeController {

    @GetMapping
    public ModelAndView showHome(){
        return new ModelAndView("index");
    }

    @PostMapping("/save")
    public ModelAndView save(@RequestParam String[] spice){
        return new ModelAndView("save","spice",spice);
    }
}