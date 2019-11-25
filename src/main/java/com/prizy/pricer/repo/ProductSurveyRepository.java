/**
 * 
 */
package com.prizy.pricer.repo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.prizy.pricer.product.domain.ProductSurvey;

/**
 * @author Ashwini Upadhyay
 * @since 1.0
 * @version 1.0
 * @date Nov 25, 2019 7:24:25 AM
 */
public interface ProductSurveyRepository extends CrudRepository<ProductSurvey, Long> {

	/**
	 * @param barcode
	 * @return List<BigDecimal>
	 */
	@Query("select pl.price from ProductSurvey pl where pl.product.barcode = ?1")
	List<BigDecimal> getPrice(String barcode);

}
