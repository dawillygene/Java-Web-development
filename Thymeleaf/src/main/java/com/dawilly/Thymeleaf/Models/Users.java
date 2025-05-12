package com.dawilly.Thymeleaf.Models;


//@Entity
public class Users {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

    private String name;
    private String email;
    private String phone;
//    private int age;
//    private String address;
//    private String city;
//    private String country;
//    private String postalCode;
//    private String password;
//    private String username;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
