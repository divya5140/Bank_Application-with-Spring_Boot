package org.training.bankapplication.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import org.training.bankapplication.entity.Account;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto {


	private String firstName;

	
	private String lastName;

	
	private int age;

	
	private String panNumber;

	
	private String emailId;

	
	private String contactNumber;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Account> account;

	
	
}
