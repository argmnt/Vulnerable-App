package com.agh.vulnerable.vulnerableapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created on January, 2019
 *
 * @author yagiz
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;

	@ManyToOne
	private Account withdrawAccount;

	private String description;

	private String depositIban;

	private LocalDate date;

}
