/**
 * 
 */
package com.prizy.pricer.dto;

import java.math.BigDecimal;

import com.prizy.pricer.product.domain.Product;

import lombok.Data;

/**
 * @author Ashwini Upadhyay
 * @since 1.0
 * @version 1.0
 * @date Nov 25, 2019 7:01:33 AM
 */
@Data
public class PriceDetail {

	private Product product;
	private BigDecimal idealPrice;
	private BigDecimal averagePrice;
	private BigDecimal lowestPrice;
	private BigDecimal highestPrice;

}
