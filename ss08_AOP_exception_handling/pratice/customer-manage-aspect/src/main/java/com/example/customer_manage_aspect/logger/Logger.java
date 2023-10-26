package com.example.customer_manage_aspect.logger;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    public void error() {
        System.out.println("[CMS] ERROR!");
    }


}