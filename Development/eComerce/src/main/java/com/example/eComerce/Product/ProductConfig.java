package com.example.eComerce.Product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {
    @Bean
    CommandLineRunner runner(ProductRepository repository) {
        return args -> {
            Product product1 = new Product("Laptop (PREDATOR)", "High-performance laptop", 1450500, 30);
            Product product2 = new Product("Smartphone (ITEL)", "Latest model smartphone", 678000, 12);
            repository.saveAll(List.of(product1, product2));
        };
    }
}