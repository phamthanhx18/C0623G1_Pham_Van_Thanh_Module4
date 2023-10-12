package com.example.dictionary.controller;

import com.example.dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping

public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryService;

    @GetMapping
    public ModelAndView showHomePage(){
        return new ModelAndView("index");
    }

    @GetMapping("/convert")
    public ModelAndView displayResultDictionary(String eng){
        return new ModelAndView("index","result", dictionaryService.displayResultDictionary(eng));
    }
}