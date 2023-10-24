package com.example.validation_form_sign_up.service;

import com.example.validation_form_sign_up.model.User;
import com.example.validation_form_sign_up.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    @Autowired
    private IUserRepo userRepo;
    @Override
    public void signUpUser(User user) {
        userRepo.save(user);
    }
}
