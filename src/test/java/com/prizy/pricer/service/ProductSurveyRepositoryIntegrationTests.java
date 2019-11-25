package com.prizy.pricer.service;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.prizy.pricer.product.domain.ProductSurvey;
import com.prizy.pricer.repo.ProductSurveyRepository;

/**
 * @author Ashwini Upadhyay
 * @since   1.0
 * @version 1.0
 * @date Nov 26, 2019 1:25:38 AM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootConfiguration
public class ProductSurveyRepositoryIntegrationTests {

	@Autowired
	ProductSurveyRepository repository;

	@Test
	public void saveProductSurvey() {
		ProductSurvey survey = new ProductSurvey();
		survey.setProductId(1l);
		survey.setStoreName("Store 1");
		survey.setPrice(new BigDecimal(33.5));
		survey.setDescription("test survey");

		ProductSurvey savedSurvey = repository.save(survey);

		assertThat(savedSurvey.getProductSurveyId(), notNullValue());
		assertThat(savedSurvey.getProductId(), is(equalTo(survey.getProductId())));
		assertThat(savedSurvey.getStoreName(), is(equalTo(survey.getStoreName())));

	}
}
