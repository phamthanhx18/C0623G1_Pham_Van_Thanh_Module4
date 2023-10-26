package com.example.rental_books.service;

import com.example.rental_books.exception.RentalException;
import com.example.rental_books.model.Rental;

public interface IRentalService {
    void creatRental(Rental rental);
    void updateRental(Rental rental);
    Rental findByCodeRental(Integer id) throws RentalException;
}
