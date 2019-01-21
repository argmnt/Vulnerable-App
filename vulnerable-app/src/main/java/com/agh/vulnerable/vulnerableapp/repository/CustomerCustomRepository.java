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
public class CustomerCustomRepository {

	@PersistenceContext
	private final EntityManager entityManager;

	public List<Object[]> getCustomer(String id) {
		List<Object[]> customer = entityManager.createNativeQuery("select * from Customer where ID="+id).getResultList();
		System.out.println();
		return customer;
	}

}
