package com.torquato.crm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.torquato.crm.models.Company;
import com.torquato.crm.services.CompanyService;

@RestController
@RequestMapping(value = "/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	// FUNÇÃO DE BUSCA TODAS "COMPANIES"
	
	@GetMapping
	public ResponseEntity<List<Company>> findAll() {
		List<Company> companies = companyService.findAll();
		return ResponseEntity.ok().body(companies);
	}

	// FUNÇÃO DE BUSCA POR ID
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Company> findById(@PathVariable Long id) {
		Company obj = companyService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
