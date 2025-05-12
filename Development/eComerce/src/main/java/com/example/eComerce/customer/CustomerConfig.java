package com.example.eComerce.customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CustomerConfig {
    @Bean
    CommandLineRunner customerRunner(customerRepository Repository) {
        return args -> {
            Customer customer1 = new Customer("juma","juma@udom.ac.tz","09876765","cive");
            Customer customer2 = new Customer("mary","mary@udom.ac.tz","098766665","coed");
            Repository.saveAll(List.of(customer1,customer2));

        };

    };

}
