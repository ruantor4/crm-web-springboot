package com.torquato.crm.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.torquato.crm.models.Customer;
import com.torquato.crm.services.CustomerService;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	// FUNÇÃO DE BUSCA TODOS "CUSTOMERS"

	@GetMapping
	public ResponseEntity<List<Customer>> findAll() {
		List<Customer> customers = customerService.findAll();
		return ResponseEntity.ok().body(customers);
	}

	// FUNÇÃO DE BUSCA POR ID

	@GetMapping(value = "/{id}")
	public ResponseEntity<Customer> findById(@PathVariable Long id) {
		Customer obj = customerService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	// FUNÇÃO DE CRIAR "CUSTOMERS"

	@PostMapping
	public ResponseEntity<Void> create(@RequestBody Customer obj) {
		customerService.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	// FUNÇÃO DE DELETAR "CUSTOMERS"

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		customerService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
