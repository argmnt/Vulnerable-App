package com.agh.vulnerable.vulnerableapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created on January, 2019
 *
 * @author yagiz
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
