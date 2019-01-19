package com.agh.vulnerable.vulnerableapp.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created on January, 2019
 *
 * @author yagiz
 */
@Entity
@Data
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private double balance;

	private double bankingScore;

	private boolean active;

	@ManyToOne
	private Customer customer;

}
