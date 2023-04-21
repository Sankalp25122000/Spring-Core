package com.aurionpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aurionpro.entity.Customer;
import com.aurionpro.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;	
	
	@Override
	public ResponseEntity<String> saveCustomer(Customer customerData) {
		customerRepository.save(customerData);
		return ResponseEntity.ok("Customer data saved");
	}

	@Override
	public Customer getCustomerById(Long customerId) {
		return customerRepository.findById(customerId).get();
	}

	@Override
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public ResponseEntity<String> updateCustomerDetails(Customer customerData) {
		customerRepository.save(customerData);
		return ResponseEntity.ok("Customer data updated");
	}

}
