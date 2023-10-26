package com.example.rental_books.controller;

import com.example.rental_books.exception.RentalException;
import com.example.rental_books.model.Book;
import com.example.rental_books.model.Rental;
import com.example.rental_books.service.IBookService;
import com.example.rental_books.service.IRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Random;

@Controller
@RequestMapping("/rental")
public class RentalController {
    @Autowired
    private IBookService bookService;

    @Autowired
    private IRentalService rentalService;

    @GetMapping("/{id}")
    public String rentalBook(@PathVariable Integer id, RedirectAttributes redirectAttributes, Model model) throws RentalException {
        Book book = bookService.getBook(id);
        if (book.getCount() == 0) {
            throw new RentalException("Mã sách này đã cho thuê hết");
        } else {
            Random rand = new Random();
            Integer codeRental;
            do {
                codeRental = rand.nextInt(100000);
            } while (rentalService.findByCodeRental(codeRental) != null);
            rentalService.creatRental(new Rental(book, codeRental, false));
            book.setCount(book.getCount() - 1);
            bookService.update(book);
            redirectAttributes.addFlashAttribute("book", book);
            redirectAttributes.addFlashAttribute("rand", codeRental);
            return "redirect:/rental/detail/";
        }
    }

    @GetMapping("/detail/")
    public String showInfo() {
        return "detail";
    }

    @GetMapping("/give/book")
    public String showForm() {
        return "give";
    }

    @PostMapping("/give/book")
    public String giveBookBack(@RequestParam Integer codeRental, Model model) throws RentalException {
        Rental rental = rentalService.findByCodeRental(codeRental);
        if (rental.getReturn()) {
            throw new RentalException("Mã sách này đã được trả trước đó !");
        } else {
            rental.setReturn(true);
            Book book = rental.getBook();
            book.setCount(book.getCount() + 1);
            bookService.update(book);
            model.addAttribute("success", "Trả sách thành công !");
            return "give";
        }
    }
}
