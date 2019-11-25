/**
 * 
 */
package com.prizy.pricer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prizy.pricer.product.domain.ProductSurvey;
import com.prizy.pricer.repo.ProductSurveyRepository;

/**
 * This class used to handle product Servey related API
 * 
 * @author Ashwini Upadhyay
 * @since 1.0
 * @version 1.0
 * @date Nov 25, 2019 6:57:29 AM
 */
@RestController
@RequestMapping("/pricer-service/")
public class ProductServeyController {

	@Autowired
	ProductSurveyRepository productSurveyRepository;

	@PostMapping("/product-servey/")
	public ProductSurvey productSurvey(@RequestBody ProductSurvey productSurvey) {
		return productSurveyRepository.save(productSurvey);
	}

	@GetMapping("/product-servey/all")
	public List<ProductSurvey> findAllServey() {
		return (List<ProductSurvey>) productSurveyRepository.findAll();
	}

}
