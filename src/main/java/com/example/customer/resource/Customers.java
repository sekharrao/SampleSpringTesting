package com.example.customer.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.model.Customer;
import com.example.customer.service.CustomerService;

@RestController
@RequestMapping("/api")
public class Customers {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/customers")
	public List<Customer> getAllCustomers(){
		return customerService.getAll();
	}
}
