package com.example.dictionary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping
public class DictionaryController {
    private static final Map<String, String> mapDictionary;
    static {
        mapDictionary = new HashMap<>();
        mapDictionary.put("Blackberry","Dâu đen");
        mapDictionary.put("Cherry","Trái anh đào");
        mapDictionary.put("Lemon","Chanh vàng");
        mapDictionary.put("Orange","Cam");
        mapDictionary.put("Apple","Táo");
        mapDictionary.put("Banana","Trái chuối");
        mapDictionary.put("Grape","Nho");
        mapDictionary.put("Mango","Xoài");
        mapDictionary.put("Melon","Dưa");
        mapDictionary.put("Watermelon","Dưa hấu");
    }


    @GetMapping
    public ModelAndView showHomePage(){
        return new ModelAndView("index");
    }

    @GetMapping("/convert")
    public ModelAndView displayResultDictionary(String eng){
        String result = mapDictionary.getOrDefault(eng, "Không tìm thấy");
        return new ModelAndView("index","result", result);
    }
}