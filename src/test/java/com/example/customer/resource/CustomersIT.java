package com.example.customer.resource;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.customer.Application;
import com.example.customer.model.Customer;
import com.example.customer.repo.CustomerRepo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes= Application.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:app-integrationtest.properties")
public class CustomersIT {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private CustomerRepo repo;
	
	@Test
	public void forValidname_getCustomer_shouldReturnResults() throws Exception {
		Customer cust1 = new Customer();
		cust1.setName("customer1");
		
		repo.saveAndFlush(cust1);
		
		mvc.perform(get("/api/customers"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[0].name", is("customer1")));
	}

}
