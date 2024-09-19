package com.torquato.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.torquato.crm.models.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}