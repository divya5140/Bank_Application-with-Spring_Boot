package org.training.bankapplication.service;

import java.util.List;

import org.training.bankapplication.dto.ResponseDto;
import org.training.bankapplication.dto.TransactionDto;
import org.training.bankapplication.entity.Transaction;

public interface TransactionService {

	ResponseDto fundTransfer(TransactionDto transactiondto);

	List<Transaction> getTransactionsByDate(String date);

}
