package com.prizy.pricer.beanshell;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.prizy.pricer.rule.IdealPriceRule;
import com.prizy.pricer.rule.IdealPriceRuleImpl;

import bsh.EvalError;
import bsh.Interpreter;

/**
 * @author Ashwini Upadhyay
 * @since   1.0
 * @version 1.0
 * @date Nov 26, 2019 1:07:56 AM
 */
public class BeanShellTest {

	public static void main(String[] args) throws IOException, EvalError {

		Interpreter interpreter = new Interpreter();

		List<BigDecimal> priceList = new ArrayList<>();
		priceList.add(new BigDecimal(32.0));
		priceList.add(new BigDecimal(32.0));
		priceList.add(new BigDecimal(342.0));
		priceList.add(new BigDecimal(35.0));
		priceList.add(new BigDecimal(62.0));
		priceList.add(new BigDecimal(37.0));

		interpreter.set("priceList", priceList);

		IdealPriceRule idealPriceRule = new IdealPriceRuleImpl();
		interpreter.set("idealPriceRule", idealPriceRule);

		Object result = interpreter.source("IdealPriceRule-rule.bsh");

		System.out.println("result " + result);

	}
}
