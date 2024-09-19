package com.torquato.crm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.torquato.crm.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}