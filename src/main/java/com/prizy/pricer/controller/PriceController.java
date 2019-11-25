/**
 * 
 */
package com.prizy.pricer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prizy.pricer.dto.PriceDetail;
import com.prizy.pricer.service.PriceService;


/**
 * This class used to handle price related API
 * 
 * @author Ashwini Upadhyay
 * @since 1.0
 * @version 1.0
 * @date Nov 25, 2019 6:57:29 AM
 */
@RestController
@RequestMapping("/pricer-service/")
public class PriceController {

	@Autowired
	PriceService priceService;

	@GetMapping("/getIdealPrice/{barcode}")
	public PriceDetail getIdealPrice(@PathVariable String barcode) {
		return priceService.getIdealPrice(barcode);
	}

}
