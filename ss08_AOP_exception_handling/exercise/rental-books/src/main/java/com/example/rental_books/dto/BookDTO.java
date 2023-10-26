package com.example.rental_books.dto;

import org.hibernate.validator.constraints.URL;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.lang.annotation.Annotation;

public class BookDTO implements Validated {

    @Size(max = 500, message = "Tên sách không được quá 500 kí tự")
    @Pattern(regexp = "^[a-zA-Z0-9\\, ]{1,}$",message = "Không được phép nhập kí tự đặc biệt (Ngoại trừ dấu ',') !")
    private String name;

    @URL(message = "Vui lòng nhập đúng đường dẫn ảnh")
    private String image;

    @Size(max = 200, message = "Tên tác giả không được quá 200 kí tự")
    @Pattern(regexp = "^[a-zA-Z0-9\\, ]{1,}$",message = "Không được phép nhập kí tự đặc biệt (Ngoại trừ dấu ',') !")
    private String author;

    @Min(value = 0,message = "Sách phải lớn hơn hoặc bằng 0")
    @Positive(message = "Phải là số nguyên !")
    private Integer count;

    public BookDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public Class<?>[] value() {
        return new Class[0];
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
