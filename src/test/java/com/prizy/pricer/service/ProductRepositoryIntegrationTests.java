package com.prizy.pricer.service;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.prizy.pricer.product.domain.Product;
import com.prizy.pricer.repo.ProductRepository;

/**
 * @author Ashwini Upadhyay
 * @since   1.0
 * @version 1.0
 * @date Nov 26, 2019 1:25:28 AM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootConfiguration
public class ProductRepositoryIntegrationTests {

	@Autowired
	ProductRepository repository;

	@Test
	public void saveProduct() {
		
		Product product = new Product();
		product.setProductId(1l);
		product.setBarcode("BXXXLL2222L");
		product.setName("Demo Product");
		product.setDescription("P1");

		Product savedProduct = repository.save(product);

		assertThat(savedProduct.getProductId(), notNullValue());
		assertThat(savedProduct.getBarcode(), is(equalTo(product.getBarcode())));
		assertThat(savedProduct.getName(), is(equalTo(product.getName())));

	}
}
