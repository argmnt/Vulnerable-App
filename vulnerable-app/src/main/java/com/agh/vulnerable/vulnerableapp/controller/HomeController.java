package com.agh.vulnerable.vulnerableapp.controller;

import com.agh.vulnerable.vulnerableapp.model.Customer;
import com.agh.vulnerable.vulnerableapp.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created on January, 2019
 *
 * @author yagiz
 */
@Controller
@AllArgsConstructor
public class HomeController {

	private final CustomerRepository customerRepository;

	@GetMapping(value = { "", "/"})
	public String showhome() {
		return 	"home";
	}

	@GetMapping(value ={"/customers"})
	@ResponseBody
	public List<Customer> getAllCustomers() {
		List<Customer> customers = customerRepository.getAllCustomers();
		System.out.println(customers.get(1).getAddress());
		return customers;
	}

}
