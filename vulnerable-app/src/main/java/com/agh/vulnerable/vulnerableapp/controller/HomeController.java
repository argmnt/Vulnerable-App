package com.agh.vulnerable.vulnerableapp.controller;

import com.agh.vulnerable.vulnerableapp.model.Account;
import com.agh.vulnerable.vulnerableapp.model.Customer;
import com.agh.vulnerable.vulnerableapp.model.Transaction;
import com.agh.vulnerable.vulnerableapp.repository.AccountCustomRepository;
import com.agh.vulnerable.vulnerableapp.repository.AccountRepository;
import com.agh.vulnerable.vulnerableapp.repository.CustomerCustomRepository;
import com.agh.vulnerable.vulnerableapp.repository.CustomerRepository;
import com.agh.vulnerable.vulnerableapp.service.CustomerService;
import com.agh.vulnerable.vulnerableapp.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

/**
 * Created on January, 2019
 *
 * @author yagiz
 */
@Controller
@AllArgsConstructor
public class HomeController {

	private final CustomerRepository customerRepository;

	private final AccountCustomRepository accountCustomRepository;

	private final AccountRepository accountRepository;

	private final CustomerCustomRepository customerCustomRepository;

	private final CustomerService customerService;

	private final TransactionService transactionService;

	@GetMapping(value = { "", "/"})
	public String showhome(Model model,Principal principal) {

		Optional<Account> accountOptional = accountRepository.findById(1L);
		model.addAttribute("account", accountOptional.get());
		model.addAttribute("username", principal.getName());
		return 	"home";
	}

	@GetMapping(value ={"/customers"})
	@ResponseBody
	public List<Customer> getAllCustomers(Principal principal, Model model) {
		List<Customer> customers = customerRepository.getAllCustomers();
		System.out.println(customers.get(1).getAddress());
		accountCustomRepository.getAccount("2");
		return customers;
	}

	@GetMapping(value = {"/customer/{id}"})
	public String showCustomer(@PathVariable String id, Model model) {
		Customer customer = customerService.getCustomer(id);
		model.addAttribute("customer", customer);
		return "customerIndex";
	}

	@GetMapping(value = {"/transactions/{id}"})
	public String showTransaction(@PathVariable String id, Model model) {
		List<Transaction> transactions = transactionService.getTransactions(id);
		model.addAttribute("transactions", transactions);
		return "transactions";
	}

}
