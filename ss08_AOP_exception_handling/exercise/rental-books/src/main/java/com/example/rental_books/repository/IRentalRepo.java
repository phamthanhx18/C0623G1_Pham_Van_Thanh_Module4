package com.example.rental_books.repository;

import com.example.rental_books.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentalRepo extends JpaRepository<Rental,Integer> {
    Rental findByCodeRental(Integer id);
}
