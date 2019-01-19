package com.agh.vulnerable.vulnerableapp.repository;

import com.agh.vulnerable.vulnerableapp.model.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created on January, 2019
 *
 * @author yagiz
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
