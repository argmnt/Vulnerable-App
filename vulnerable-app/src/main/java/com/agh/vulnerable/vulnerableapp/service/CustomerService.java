package com.agh.vulnerable.vulnerableapp.service;

import com.agh.vulnerable.vulnerableapp.model.Customer;
import com.agh.vulnerable.vulnerableapp.repository.CustomerCustomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on January, 2019
 *
 * @author yagiz
 */
@Service
@AllArgsConstructor
public class CustomerService {

	private final CustomerCustomRepository customerCustomRepository;

	public Customer getCustomer(String id) {
		List<Object[]> customerObjectList = customerCustomRepository.getCustomer(id);
		Object[] customerObject = customerObjectList.get(0);
		Customer customer = Customer.builder().address(customerObject[1].toString()).fullName(customerObject[2].toString()).identityNo(customerObject[3].toString())
				.password(customerObject[4].toString()).phone(customerObject[5].toString()).username(customerObject[6].toString()).build();
		return customer;
	}

}
