package com.agh.vulnerable.vulnerableapp.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

/**
 * Created on January, 2019
 *
 * @author yagiz
 */
@Entity
@Data
@Builder
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String accountNumber;

	private double balance;

	private double bankingScore;

	private boolean active;

	@ManyToOne
	private Customer customer;

}
