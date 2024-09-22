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

	// FUNÇÃO DE CRIAR "CUSTOMERS"

	public Customer create(Customer obj) {
		return customerRepository.save(obj);

	}

	// FUNÇÃO DE DELETAR "CUSTOMERS"

	public void delete(Long id) {
		findById(id);
		customerRepository.deleteById(id);
	}

	// FUNÇÃO DE EDITAR "CUSTOMERS"

	public Customer update(Long id, Customer obj) {
		Customer customer = customerRepository.getReferenceById(id);
		updateData(customer, obj);
		return customerRepository.save(customer);

	}

	public void updateData(Customer customer, Customer obj) {
		customer.setcustomerName(obj.getcustomerName());
		customer.setPosition(obj.getPosition());
		customer.setCelphone(obj.getCelphone());
		customer.setEmail(obj.getEmail());

	}

}
