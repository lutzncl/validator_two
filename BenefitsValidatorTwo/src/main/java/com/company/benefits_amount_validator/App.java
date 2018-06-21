package com.company.benefits_amount_validator;

import com.company.benefits_amount_validator.model.Frequency;
import com.company.benefits_amount_validator.model.RegularAmount;

public class App {
	
	public static void main(String[] args) {
		RegularAmount ra = new RegularAmount(Frequency.WEEK, "57.90");
		System.out.println(ra.getAmount());
		
	}
}
