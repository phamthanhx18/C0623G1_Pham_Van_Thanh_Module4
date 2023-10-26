package com.example.rental_books.model;

import javax.persistence.*;

@Entity
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codeRental;
    private boolean isReturn;

    public Rental() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getCodeRental() {
        return codeRental;
    }

    public void setCodeRental(Integer codeRental) {
        this.codeRental = codeRental;
    }

    public Boolean getReturn() {
        return isReturn;
    }

    public void setReturn(Boolean aReturn) {
        isReturn = aReturn;
    }

    public Rental(Book book, Integer codeRental, Boolean isReturn) {
        this.book = book;
        this.codeRental = codeRental;
        this.isReturn = isReturn;
    }
}
