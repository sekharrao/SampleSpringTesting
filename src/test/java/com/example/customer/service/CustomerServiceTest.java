package com.example.customer.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.customer.model.Customer;
import com.example.customer.repo.CustomerRepo;

@RunWith(SpringRunner.class)
public class CustomerServiceTest {
	
	@TestConfiguration
	static class Testconfig{
		@Bean
		public CustomerService customerService() {
			return new CustomerService();
		}
	}

	@Autowired
	private CustomerService customerService;
	
	@MockBean
	private CustomerRepo customerRepo;
	@Before
	public void setUp() throws Exception {
		Customer customer1 = new Customer();
		customer1.setName("cust1");
		when(customerRepo.findByName("cust1")).thenReturn(customer1);
	}

	@Test
	public void givenCorrectName_customerShouldBeFound() {
		Customer customer1 = customerService.findOne("cust1");
		assertThat(customer1.getName()).isEqualTo("cust1");
	}

}
