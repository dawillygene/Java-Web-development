package com.example.eComerce;

import com.example.eComerce.customer.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication

public class EComerceApplication {

	public static void main(String[] args) {

		SpringApplication.run(EComerceApplication.class, args);
	}


}
