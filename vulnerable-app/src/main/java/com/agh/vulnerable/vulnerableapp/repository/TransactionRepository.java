package com.agh.vulnerable.vulnerableapp.repository;

import com.agh.vulnerable.vulnerableapp.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created on January, 2019
 *
 * @author yagiz
 */
@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

}
