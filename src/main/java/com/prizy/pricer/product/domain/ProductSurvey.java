/**
 * 
 */
package com.prizy.pricer.product.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author Ashwini Upadhyay
 * @since 1.0
 * @version 1.0
 * @date Nov 25, 2019 7:31:53 AM
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSurvey implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@JsonIgnore
	private Long productSurveyId;

	@Column(name = "product_id")
	private Long productId;

	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "product_id", insertable = false, updatable = false)
	@JsonIgnore
	private Product product;

	@NotNull
	private BigDecimal price;

	private String storeName;

	private String description;

}
