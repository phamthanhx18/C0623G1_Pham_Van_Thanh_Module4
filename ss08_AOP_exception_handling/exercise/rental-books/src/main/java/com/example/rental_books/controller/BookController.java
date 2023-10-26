package com.example.rental_books.controller;

import com.example.rental_books.dto.BookDTO;
import com.example.rental_books.model.Book;
import com.example.rental_books.service.IBookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping
    public ModelAndView showHome(){
        return new ModelAndView("index","books",bookService.getAllBook());
    }

    @GetMapping("/add")
    public ModelAndView showFromAddBook(){
        return new ModelAndView("add","bookDTO",new BookDTO());
    }

    @PostMapping("/add")
    public ModelAndView creatBook(@Valid @ModelAttribute BookDTO bookDTO, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return new ModelAndView("add","bookDTO",bookDTO);
        } else {
            Book book = new Book();
            BeanUtils.copyProperties(bookDTO,book);
            bookService.creatBook(book);
            return showHome();
        }
    }
}
