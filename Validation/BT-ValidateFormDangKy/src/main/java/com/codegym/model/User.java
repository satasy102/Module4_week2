package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @NotEmpty(message = "Khong duoc bo trong")
    @Size(min = 2, max = 45, message = "Gioi han tu 2-20 ky tu")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Chi chua ky tu dang chu cai")
    private String firstname;


    @NotEmpty(message = "Khong duoc bo trong")
    @Size(min = 2, max = 45, message = "Gioi han tu 2-20 ky tu")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Chi chua ky tu dang chu cai")
    private String lastname;


    @Min(value = 18, message = "Toi thieu tu 18 tuoi")
    private int age;

    @NotBlank
    private String phone;

    @Email(message = "Khong dung dinh dang Email")
    private String email;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
