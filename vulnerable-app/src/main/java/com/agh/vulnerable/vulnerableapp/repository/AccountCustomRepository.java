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
public class AccountCustomRepository {

	@PersistenceContext
	private final EntityManager entityManager;

	public void getAccount(String id) {
		List<Object[]> accounts = entityManager.createNativeQuery("select * from Account where CUSTOMER_ID="+id).getResultList();
		System.out.println();
	}

}
