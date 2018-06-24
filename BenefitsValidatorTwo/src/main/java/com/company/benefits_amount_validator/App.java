package com.company.benefits_amount_validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.company.benefits_amount_validator.model.Frequency;
import com.company.benefits_amount_validator.model.RegularAmount;

public class App {
	private static Logger logger = LoggerFactory.getLogger(App.class);
	public static void main(String[] args) {
		RegularAmount ra = new RegularAmount(Frequency.WEEK, "57.90");
		System.out.println(ra.getAmount());
		
		logger.info("Hello from the logger");
		
	}
}
