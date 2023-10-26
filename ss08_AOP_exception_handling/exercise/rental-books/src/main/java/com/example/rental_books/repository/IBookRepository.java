package com.example.rental_books.repository;

import com.example.rental_books.model.Book;
import com.example.rental_books.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBookRepository extends JpaRepository<Book,Integer> {
}
