package com.example.dictionary.controller;

import com.example.dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView displayResultDictionary(Model model,String eng){
        model.addAttribute("eng",eng);
        model.addAttribute("vi",dictionaryService.displayResultDictionary(eng));
        return new ModelAndView("index");
    }
}