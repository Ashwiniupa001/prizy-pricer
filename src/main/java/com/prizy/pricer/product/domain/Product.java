/**
 * 
 */
package com.prizy.pricer.product.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ashwini Upadhyay
 * @since 1.0
 * @version 1.0
 * @date Nov 25, 2019 7:38:38 AM
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "product_id")
	private Long productId;
	
	@Column(nullable = false, unique = true)
	private String barcode;

	@Column(nullable = false)
	private String name;

	@Column
	private String description;

}
