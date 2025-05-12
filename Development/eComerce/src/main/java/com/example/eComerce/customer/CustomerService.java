package com.example.eComerce.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService {
    private final customerRepository customerRepository;
    @Autowired
    public CustomerService(customerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }
}
