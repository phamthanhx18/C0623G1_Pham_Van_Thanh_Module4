package com.example.rental_books.config;

import com.example.rental_books.model.Book;
import com.example.rental_books.service.IBookService;
import com.example.rental_books.utils.FileUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
@Aspect
public class AspectLog {
    @Autowired
    private IBookService bookService;
    @Pointcut("execution(* com.example.rental_books.controller.RentalController.rentalBook(..))")
    public void rentalBook(){}

    @Pointcut("execution(* com.example.rental_books.controller.RentalController.giveBookBack(..))")
    public void giveBookBack(){}

    @Pointcut("within(com.example.rental_books.controller.*)")
    public void allMethodBook(){}


    @After("rentalBook()")
    public void afterRentalBook(JoinPoint joinPoint){
        String pathFile = "D:\\CodeGym\\C0623G1_Pham_Van_Thanh_Module4\\ss08_AOP_exception_handling\\exercise\\rental-books\\src\\main\\java\\com\\example\\rental_books\\data\\log-change-status-book";
        List<String> listLog = FileUtils.readFile(pathFile);
        String log = "Use rental Book. Start method name " + joinPoint.getSignature().getName() + " Time: "+ LocalDateTime.now();
        listLog.add(log);
        FileUtils.writeFile(pathFile,listLog);
    }

    @After("giveBookBack()")
    public void afterGiveBookBack(JoinPoint joinPoint){
        String pathFile = "D:\\CodeGym\\C0623G1_Pham_Van_Thanh_Module4\\ss08_AOP_exception_handling\\exercise\\rental-books\\src\\main\\java\\com\\example\\rental_books\\data\\log-change-status-book";
        List<String> listLog = FileUtils.readFile(pathFile);
        String log = "Use Give Book.Start method name " + joinPoint.getSignature().getName() + " Time: "+ LocalDateTime.now();
        listLog.add(log);
        FileUtils.writeFile(pathFile,listLog);
    }

    @After("allMethodBook()")
    public void afterMethod(JoinPoint joinPoint){
        String pathFile = "D:\\CodeGym\\C0623G1_Pham_Van_Thanh_Module4\\ss08_AOP_exception_handling\\exercise\\rental-books\\src\\main\\java\\com\\example\\rental_books\\data\\log-all-method";
        List<String> listLog = FileUtils.readFile(pathFile);
        String log = "Start method name " + joinPoint.getSignature().getName() + " Time: "+ LocalDateTime.now();
        listLog.add(log);
        FileUtils.writeFile(pathFile,listLog);
    }

}
