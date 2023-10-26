package com.example.rental_books.service;

import com.example.rental_books.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAllBook();
    void creatBook(Book book);
    void update(Book book);
    Book getBook(Integer id);
}
