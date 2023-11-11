package org.training.bankapplication.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionDto {

	
	private long fromAccountNumber;

	private long toAccountNumber;

	private float amount;
}
