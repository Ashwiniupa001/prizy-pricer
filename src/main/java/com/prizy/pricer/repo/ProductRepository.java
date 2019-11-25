/**
 * 
 */
package com.prizy.pricer.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.prizy.pricer.product.domain.Product;

/**
 * @author Ashwini Upadhyay
 * @since   1.0
 * @version 1.0
 * @date Nov 25, 2019 7:24:45 AM
 */
public interface ProductRepository extends CrudRepository<Product, Long> {

    Product findByBarcode(String barcode);

	Page<Product> findByNameContainingAllIgnoringCase(String name, Pageable pageable);

}
