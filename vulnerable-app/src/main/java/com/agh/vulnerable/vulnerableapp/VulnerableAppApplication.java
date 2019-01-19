package com.agh.vulnerable.vulnerableapp;

import com.agh.vulnerable.vulnerableapp.model.Account;
import com.agh.vulnerable.vulnerableapp.model.Customer;
import com.agh.vulnerable.vulnerableapp.repository.AccountRepository;
import com.agh.vulnerable.vulnerableapp.repository.CustomerRepository;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class VulnerableAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(VulnerableAppApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner(AccountRepository accountRepository, CustomerRepository customerRepository) {
		return args -> {

			Fairy fairy = Fairy.create();
			//Customers
			ArrayList<Customer> customers = new ArrayList<>();
			for (int i = 1; i<10; i++) {
				Person person = fairy.person();
				Customer customer = Customer.builder().address(person.getAddress().toString()).fullName(person.getFullName()).identityNo(
						person.getNationalIdentityCardNumber()).phone(person.getTelephoneNumber()).password("password").username("customer" + i).build();
				Customer savedCustomer = customerRepository.save(customer);
				customers.add(savedCustomer);
			}
			//Accounts
			List<Account> accounts = new ArrayList<>();
			for(int i = 1; i<10; i++) {
					Account account = Account.builder().active(true).balance(fairy.baseProducer().randomBetween(500, 100000)).bankingScore(
							fairy.baseProducer().randomBetween(60, 100)).accountNumber("111111111111111" + String.valueOf(i))
							.customer(customers.get(i-1)).build();
					accountRepository.save(account);
			}
		};
	}

}

