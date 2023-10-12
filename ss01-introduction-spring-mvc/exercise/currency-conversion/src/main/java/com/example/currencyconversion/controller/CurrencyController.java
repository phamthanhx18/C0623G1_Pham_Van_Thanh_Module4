package com.example.currencyconversion.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class CurrencyController {
    @GetMapping()
    public ModelAndView showHome() {
        return new ModelAndView("index");
    }

    @GetMapping("/convert")
    public ModelAndView convertMoneyUsdToVnd(double usd) {
        double vnd = usd*23000;
        return new ModelAndView("index","vnd",vnd);
    }

}
