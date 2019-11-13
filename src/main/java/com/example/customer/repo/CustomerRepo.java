package com.example.customer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.customer.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
	
	public Customer findByName(String name);

}
