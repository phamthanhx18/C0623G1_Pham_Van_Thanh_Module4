package com.example.validation_form_sign_up.controller;

import com.example.validation_form_sign_up.dto.UserDTO;
import com.example.validation_form_sign_up.model.User;
import com.example.validation_form_sign_up.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping
    public ModelAndView showFormCreate(){
        return new ModelAndView("index","userDTO",new UserDTO());
    }

    @PostMapping
    public ModelAndView saveUser(@Valid @ModelAttribute UserDTO userDTO,
                                 BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return new ModelAndView("index","userDTO", userDTO);
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDTO,user);
            userService.signUpUser(user);
            return new ModelAndView("result","user",user);
        }
    }

}
