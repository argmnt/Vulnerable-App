package com.agh.vulnerable.vulnerableapp.repository;

import com.agh.vulnerable.vulnerableapp.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created on January, 2019
 *
 * @author yagiz
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	@Query(value = "SELECT * FROM Customer", nativeQuery = true)
	List<Customer> getAllCustomers();

}
