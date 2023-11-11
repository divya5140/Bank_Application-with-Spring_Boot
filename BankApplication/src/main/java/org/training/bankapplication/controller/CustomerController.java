package org.training.bankapplication.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.training.bankapplication.dto.Customer2Dto;
import org.training.bankapplication.dto.CustomerDto;
import org.training.bankapplication.dto.ResponseDto;
import org.training.bankapplication.entity.Customer;
import org.training.bankapplication.service.CustomerService;

@RestController
@RequestMapping("/bank")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping("/addCustomer")
	public ResponseEntity<ResponseDto> addCustomer(@RequestBody @Valid CustomerDto customer) {

		return new ResponseEntity<ResponseDto>(customerService.addCustomer(customer), HttpStatus.CREATED);
	}

	@GetMapping("/findbyid/{customerId}")
	public ResponseEntity<Customer> getCustomer(@PathVariable long customerId) {
		return new ResponseEntity<Customer>(customerService.getById(customerId), HttpStatus.CREATED);

	}

	@PutMapping("/updateCustomer/{customerId}")
	public ResponseEntity<ResponseDto> updateCustomer(@RequestBody Customer2Dto customer,@PathVariable long customerId) {

		return new ResponseEntity<ResponseDto>(customerService.updateById(customer,customerId), HttpStatus.CREATED);

	}

	@DeleteMapping("/deletebyid/{customerId}")
	public ResponseEntity<ResponseDto> DeleteCustomer(@PathVariable long customerId) {
		return new ResponseEntity<ResponseDto>(customerService.deleteById(customerId), HttpStatus.CREATED);

	}

}
