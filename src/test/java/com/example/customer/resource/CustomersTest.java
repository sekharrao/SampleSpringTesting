package com.example.customer.resource;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.customer.model.Customer;
import com.example.customer.service.CustomerService;

@RunWith(SpringRunner.class)
@WebMvcTest(Customers.class)
public class CustomersTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private CustomerService service;

	@Test
	public void givenCustomers_whenGetAllCustomers_thenReturnArray() throws Exception {
		
		Customer customer1 = new Customer();
		customer1.setName("customer1");
		
		when(service.getAll()).thenReturn(Arrays.asList(customer1));
		
		mvc.perform(get("/api/customers")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].name", is(customer1.getName())));
	}
}
