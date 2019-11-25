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

import com.prizy.pricer.product.domain.Product;
import com.prizy.pricer.repo.ProductRepository;

/**
 * This class used to handle product related API
 * 
 * @author Ashwini Upadhyay
 * @since 1.0
 * @version 1.0
 * @date Nov 25, 2019 6:57:29 AM
 */
@RestController
@RequestMapping("/pricer-service/")
public class ProductController {

	@Autowired
	ProductRepository productRepository;

	@PostMapping("/product/")
	public Product createProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}

	@GetMapping("/product/all")
	public List<Product> findAllProduct() {
		return (List<Product>) productRepository.findAll();
	}

}
