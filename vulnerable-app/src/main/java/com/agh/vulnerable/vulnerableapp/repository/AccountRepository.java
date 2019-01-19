package com.agh.vulnerable.vulnerableapp.repository;

import com.agh.vulnerable.vulnerableapp.model.Account;
import org.springframework.data.repository.CrudRepository;

/**
 * Created on January, 2019
 *
 * @author yagiz
 */
public interface AccountRepository extends CrudRepository<Account, Long> {

}
