package com.torquato.crm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.torquato.crm.models.Customer;
import com.torquato.crm.repositories.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	// FUNÇÃO DE BUSCA TODOS "CUSTOMERS"

	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	// FUNÇÃO DE BUSCA POR ID

	public Customer findById(Long id) {
		Optional<Customer> obj = customerRepository.findById(id);
		return obj.get();
	}
}
