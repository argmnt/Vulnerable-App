package com.agh.vulnerable.vulnerableapp;

import com.agh.vulnerable.vulnerableapp.repository.AccountRepository;
import com.agh.vulnerable.vulnerableapp.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VulnerableAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(VulnerableAppApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(AccountRepository accountRepository, CustomerRepository customerRepository) {
		return args -> {

			

		};
	}

}

