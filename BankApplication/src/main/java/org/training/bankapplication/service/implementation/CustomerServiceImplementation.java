package org.training.bankapplication.service.implementation;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.training.bankapplication.dto.Customer2Dto;
import org.training.bankapplication.dto.CustomerDto;
import org.training.bankapplication.dto.ResponseDto;
import org.training.bankapplication.entity.Customer;
import org.training.bankapplication.exception.CustomerIdNotFoundException;
import org.training.bankapplication.repository.AccountRepository;
import org.training.bankapplication.repository.CustomerRepository;
import org.training.bankapplication.repository.TransactionRepository;
import org.training.bankapplication.service.CustomerService;

@Service
public class CustomerServiceImplementation implements CustomerService {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public ResponseDto addCustomer(CustomerDto customer) {
		Customer customer2 = new Customer();
		customer.getAccount().stream().forEach(account -> account
				.setAccountNumber((long) (Math.floor(Math.random() * 9000000000000l) + 1000000000000l)));

		BeanUtils.copyProperties(customer, customer2);
		customerRepository.save(customer2);

		return new ResponseDto("Customer Details added and Account created");

	}

	public Customer getById(long customerId) {
		return customerRepository.findById(customerId)
				.orElseThrow(() -> new CustomerIdNotFoundException("No Customer present with id=" + customerId));
	}

	public ResponseDto updateById(Customer2Dto customer, Long customerId) {
		Customer customer2 = customerRepository.findById((Long) customerId).get();
		if (customer2 == null) {
			throw new CustomerIdNotFoundException("No User is present with id " + customerId);
		}
		customer2.setFirstName(customer.getFirstName());
		customer2.setLastName(customer.getLastName());
		customer2.setAge(customer.getAge());
		customer2.setPanNumber(customer.getPanNumber());
		customer2.setEmailId(customer.getEmailId());
		customer2.setContactNumber(customer.getContactNumber());

		customerRepository.save(customer2);
		return new ResponseDto("Customer Details updated successfully");

	}

	public ResponseDto deleteById(long customerId) {
		Optional<Customer> customer = customerRepository.findById(customerId);
		if (customer.isEmpty()) {
			return new ResponseDto("Customer with customerId: " + customerId + " not found");
		}
		customerRepository.deleteById(customerId);

		return new ResponseDto("Customer deleted successfully");
	}
}
