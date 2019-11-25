package com.prizy.pricer.rule;

import bsh.EvalError;
import bsh.Interpreter;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.ResourceBundle;

/**
 * This class uses BeanShell to interpret dynamic rules
 */
@Slf4j
public class RuleInterpreter {

	public static BigDecimal interpretProductIdealPriceRule(List<BigDecimal> priceList) {
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String ruleDirectory = bundle.getString("rule.directory");
		String ruleFilePath = ruleDirectory + File.separator + IdealPriceRule.class.getSimpleName() + "-rule.bsh";

		IdealPriceRule idealPriceRule = new IdealPriceRuleImpl();
		Interpreter interpreter = new Interpreter();

		try {
			interpreter.set("priceList", priceList);
			interpreter.set("idealPriceRule", idealPriceRule);
			Object result = interpreter.source(ruleFilePath);
			return (BigDecimal) result;
		} catch (IOException | EvalError e) {
			log.error("error while interpreting", e);
		}
		return null;
	}

}
