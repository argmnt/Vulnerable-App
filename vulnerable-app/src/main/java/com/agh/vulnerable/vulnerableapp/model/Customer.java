package com.agh.vulnerable.vulnerableapp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * Created on January, 2019
 *
 * @author yagiz
 */
@Entity
@Data
public class Customer {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private long Id;

	private String fullName;

	private String username;

	private String password;

	private String identityNo;

	private String phone;

	private String address;

	@OneToMany(mappedBy = "customer")
	private Set<Account> accounts;

}
