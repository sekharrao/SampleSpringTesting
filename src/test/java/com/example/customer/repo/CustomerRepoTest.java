package com.example.customer.repo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.customer.model.Customer;

@RunWith(SpringRunner.class)
@DataJpaTest
class CustomerRepoTest {

	@Autowired
	private TestEntityManager entityMgr;

	@Autowired
	private CustomerRepo repo;

	@Test
	public void givenValidName_findByName_shouldReturnRecord() {
		Customer cust1 = new Customer();
		cust1.setName("cust1");

		entityMgr.persist(cust1);
		entityMgr.flush();

		Customer response = repo.findByName("cust1");
		assertThat(response.getName()).isEqualTo("cust1");
	}

}
