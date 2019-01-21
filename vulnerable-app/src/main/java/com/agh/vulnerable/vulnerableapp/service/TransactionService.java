package com.agh.vulnerable.vulnerableapp.service;

import com.agh.vulnerable.vulnerableapp.model.Transaction;
import com.agh.vulnerable.vulnerableapp.repository.TransactionCustomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on January, 2019
 *
 * @author yagiz
 */
@Service
@AllArgsConstructor
public class TransactionService {

	private final TransactionCustomRepository transactionCustomRepository;

	public List<Transaction> getTransactions(String id) {
		List<Object[]> transactionObjectList = transactionCustomRepository.getCustomer(id);
		List<Transaction> transactions = new ArrayList<>();
		//Transactions Added
		transactionObjectList.forEach(transaction -> {
			Transaction transactionWillBeAdded = Transaction.builder().date(LocalDate.parse(transaction[1].toString(),DateTimeFormatter.ofPattern("yyyy-MM-dd")))
					.depositIban(transaction[2].toString()).description(transaction[3].toString()).build();
			transactions.add(transactionWillBeAdded);
		});
//		Customer customer = Customer.builder().address(customerObject[1].toString()).fullName(customerObject[2].toString()).identityNo(customerObject[3].toString())
//				.password(customerObject[4].toString()).phone(customerObject[5].toString()).username(customerObject[6].toString()).build();
//		return customer;
		return transactions;
	}

}
