package org.training.bankapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.training.bankapplication.dto.ResponseDto;
import org.training.bankapplication.dto.TransactionDto;
import org.training.bankapplication.entity.Transaction;
import org.training.bankapplication.service.TransactionService;

@RestController
@RequestMapping("/trans")
public class TransactionController {

	@Autowired
	TransactionService transactionService;



	@PostMapping("/fundTransfer")
	public ResponseDto fundTransfer(@RequestBody TransactionDto transactiondto) {
		return transactionService.fundTransfer(transactiondto);
				
	}
	
	 @GetMapping("getStatement")
	    public List<Transaction> getTransactionsByDate(@RequestParam String date) {
	        return transactionService.getTransactionsByDate(date);
	    }
	
	
	

}
