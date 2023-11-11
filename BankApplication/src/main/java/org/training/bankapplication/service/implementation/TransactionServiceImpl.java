package org.training.bankapplication.service.implementation;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.training.bankapplication.dto.ResponseDto;
import org.training.bankapplication.dto.TransactionDto;
import org.training.bankapplication.entity.Account;
import org.training.bankapplication.entity.Transaction;
import org.training.bankapplication.repository.AccountRepository;
import org.training.bankapplication.repository.TransactionRepository;
import org.training.bankapplication.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public ResponseDto fundTransfer(TransactionDto transactiondto) {

		Account account1 = new Account();
		Account account2 = new Account();

		account1 = accountRepository.findAccountByAccountNumber(transactiondto.getFromAccountNumber());
		if (account1 == null) {
			return new ResponseDto("fromAccountNumber Number Invalid");
		}

		account2 = accountRepository.findAccountByAccountNumber(transactiondto.getToAccountNumber());

		if (account2 == null) {
			return new ResponseDto("toAccountNumber Number Invalid");
		}

		if (account1.getBalance() <= 500) {
			return new ResponseDto("Minimum Account balance should be 500");
		}

		if (account1.getBalance() - transactiondto.getAmount() > 0) {
			account1.setBalance(account1.getBalance() - transactiondto.getAmount());
			account2.setBalance(account2.getBalance() + transactiondto.getAmount());

			accountRepository.save(account1);
			accountRepository.save(account2);

			Transaction transaction = new Transaction();
			transaction.setFromAccountNumber(transactiondto.getFromAccountNumber());
			transaction.setToAccountNumber(transactiondto.getToAccountNumber());
			transaction.setAmount(transactiondto.getAmount());

			transactionRepository.save(transaction);

			return new ResponseDto("Fund transfer was successfull");

		}
		return new ResponseDto("not transferred");

	}
	public List<Transaction> getTransactionsByDate(String date) {
		return transactionRepository.findByTransactionDateTime(Date.valueOf(date));
	}
	
	

}
