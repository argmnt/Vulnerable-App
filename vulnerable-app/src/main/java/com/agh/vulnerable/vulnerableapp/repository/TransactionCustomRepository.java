package com.agh.vulnerable.vulnerableapp.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created on January, 2019
 *
 * @author yagiz
 */
@Component
@AllArgsConstructor
public class TransactionCustomRepository {

	@PersistenceContext
	private final EntityManager entityManager;

	public List<Object[]> getCustomer(String id) {
		List<Object[]> transactons = entityManager.createNativeQuery("select * from Transaction "
																		  + "where WITHDRAW_ACCOUNT_ID="+id).getResultList();
		return transactons;
	}

}
