package org.training.bankapplication.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long accountId;

	@NotNull
	private long accountNumber;

	@NotNull(message = "Account type should be mentioned")
	@Pattern(regexp = "^(?:current|savings|other)$", message = "please enter valid account type")
	private String accountType;

	@NotNull(message = "Minimum balance  is required")
	@Min(value = 500, message = "Minimum Initial deposit should be Rs.500")
	private float balance;

}
