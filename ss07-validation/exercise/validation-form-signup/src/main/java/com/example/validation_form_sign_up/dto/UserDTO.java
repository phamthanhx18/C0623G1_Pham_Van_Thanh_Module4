package com.example.validation_form_sign_up.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class UserDTO implements Validator {

    @NotEmpty(message = "Không được để trống")
    @Size(min = 6,message = "Không được bé hơn 8 kí tự")
    @Size(max = 20,message = "Không được lớn hơn 20 kí tự")
    private String username;

    @NotEmpty(message = "Không được để trống")
    @Size(min = 8,message = "Không được bé hơn 8 kí tự")
    @Size(max = 20,message = "Không được lớn hơn 20 kí tự")
    private String password;

    @Size(min = 5,message = "Không được bé hơn 5 kí tự")
    @Size(max = 45,message = "Không được lớn hơn 45 kí tự")
    private String firstName;

    @Size(min = 5,message = "Không được bé hơn 5 kí tự")
    @Size(max = 45,message = "Không được lớn hơn 45 kí tự")
    private String lastName;

    @Pattern(regexp = "(84|0[3|5|7|8|9])+([0-9]{8})",message = "Không đúng định dạng số điện thoại")
    private String phoneNumber;

    private String age;

    @Email(message = "Khong dung dinh dang email")
    private String email;

    public UserDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO userDTO = (UserDTO) target;
        LocalDate age = LocalDate.parse(userDTO.getAge());
        if (Period.between(age, LocalDate.now()).getYears() < 18){
            errors.rejectValue("age","age.under.accept","Không được dưới 18 tuổi");
        }
    }
}
