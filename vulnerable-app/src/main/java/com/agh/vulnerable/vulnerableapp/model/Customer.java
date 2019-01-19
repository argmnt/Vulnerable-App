package com.agh.vulnerable.vulnerableapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

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
public class Customer {

	public Customer(long id, String fullName, String username, String password, String identityNo, String phone, String address) {
		this.Id = Id;
		this.fullName = fullName;
		this.username = username;
		this.password = password;
		this.identityNo = identityNo;
		this.phone = phone;
		this.address = address;

	}

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

	@Override
	public String toString() {
		return "Customer{" + "Id=" + Id + ", fullName='" + fullName + '\'' + ", username='" + username + '\'' + ", password='" + password + '\''
				+ ", identityNo='" + identityNo + '\'' + ", phone='" + phone + '\'' + ", address='" + address + '\'' + '}';
	}
}
