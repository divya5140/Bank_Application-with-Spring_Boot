package org.training.bankapplication.service;

import org.training.bankapplication.dto.Customer2Dto;
import org.training.bankapplication.dto.CustomerDto;
import org.training.bankapplication.dto.ResponseDto;
import org.training.bankapplication.entity.Customer;

public interface CustomerService {

	ResponseDto addCustomer(CustomerDto customer);
	
	Customer getById(long customerId);
	
	ResponseDto updateById(Customer2Dto customer,Long customerId);
	
	ResponseDto deleteById(long customerId);
	


	
}
