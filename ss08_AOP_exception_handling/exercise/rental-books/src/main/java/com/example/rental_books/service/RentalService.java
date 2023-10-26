package com.example.rental_books.service;

import com.example.rental_books.exception.RentalException;
import com.example.rental_books.model.Rental;
import com.example.rental_books.repository.IRentalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentalService implements IRentalService{
    @Autowired
    private IRentalRepo rentalRepo;
    @Override
    public void creatRental(Rental rental) {
        rentalRepo.save(rental);
    }

    @Override
    public void updateRental(Rental rental) {
        rentalRepo.save(rental);
    }

    @Override
    public Rental findByCodeRental(Integer id) throws RentalException {
        if (rentalRepo.findByCodeRental(id) == null) {
            throw new RentalException("Mã không tồn tại hoặc không chính xác");
        }
        return rentalRepo.findByCodeRental(id);
    }
}
