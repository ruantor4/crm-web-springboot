package com.torquato.crm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.torquato.crm.models.Company;
import com.torquato.crm.repositories.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	// FUNÇÃO DE BUSCA TODAS "COMPANIES"

	public List<Company> findAll() {
		return companyRepository.findAll();
	}

	// FUNÇÃO DE BUSCA POR ID

	public Company findById(Long id) {
		Optional<Company> obj = companyRepository.findById(id);
		return obj.get();
	}

	// FUNÇÃO DE CRIAR "COMPANY"
	
	public Company create(Company obj) {
		return companyRepository.save(obj);
		
	}
	
	// FUNÇÃO DE DELETAR "COMPANY"
	
	public void delete(Long id) {
		findById(id);
		companyRepository.deleteById(id);
	}
	
	
}
