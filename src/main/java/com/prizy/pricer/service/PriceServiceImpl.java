/**
 * 
 */
package com.prizy.pricer.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prizy.pricer.dto.PriceDetail;
import com.prizy.pricer.repo.ProductRepository;
import com.prizy.pricer.repo.ProductSurveyRepository;
import com.prizy.pricer.rule.IdealPriceRule;
import com.prizy.pricer.rule.IdealPriceRuleImpl;
import com.prizy.pricer.rule.RuleInterpreter;

/**
 * @author Ashwini Upadhyay
 * @since 1.0
 * @version 1.0
 * @date Nov 25, 2019 7:14:45 AM
 */
@Service
public class PriceServiceImpl implements PriceService {

	@Autowired
	ProductSurveyRepository productSurveyRepository;

	@Autowired
	ProductRepository productRepository;

	@Override
	public PriceDetail getIdealPrice(String barcode) {

		IdealPriceRule rule = new IdealPriceRuleImpl();
		List<BigDecimal> priceList = productSurveyRepository.getPrice(barcode);

		List<BigDecimal> clonedList = new ArrayList<>(priceList);

		BigDecimal idealPrice = RuleInterpreter.interpretProductIdealPriceRule(clonedList);

		Collections.sort(priceList);

		PriceDetail detail = new PriceDetail();

		detail.setProduct(productRepository.findByBarcode(barcode));

		detail.setIdealPrice(idealPrice);
		detail.setAveragePrice(rule.calculateAveragePrice(priceList));
		detail.setLowestPrice(rule.calculateLowestPrice(priceList));
		detail.setHighestPrice(rule.calculateHighestPrice(priceList));

		return detail;

	}

}
