/**
 * 
 */
package com.prizy.pricer.service;

import org.springframework.stereotype.Service;

import com.prizy.pricer.dto.PriceDetail;

/**
 * @author Ashwini Upadhyay
 * @since 1.0
 * @version 1.0
 * @date Nov 25, 2019 7:01:15 AM
 */
@Service
public interface PriceService {

	PriceDetail getIdealPrice(String barcode);

}
