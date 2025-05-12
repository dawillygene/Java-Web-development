package com.example.eComerce.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/customer")
public class CustomerControler {
    private final CustomerService customerService;
    @Autowired
    public CustomerControler(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> Hello(){
       return customerService.getCustomers();
    }
}
