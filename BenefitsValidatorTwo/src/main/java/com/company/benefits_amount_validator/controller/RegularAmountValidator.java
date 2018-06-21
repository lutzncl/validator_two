package com.company.benefits_amount_validator.controller;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.company.benefits_amount_validator.model.RegularAmount;

/**
 * Custom validator class to verifying if entered amount is valid based on the frequency. 
 * Amounts must be divisible to a one week frequency except for the MONTH value.
 * @author lutzlemmer
 *
 */
public class RegularAmountValidator implements ConstraintValidator<ValidateRegularAmount, RegularAmount> {
	
	public void initialize(ValidateRegularAmount validateRegularAmount) {
	}

	@Override
	public boolean isValid(RegularAmount ra, ConstraintValidatorContext context) {
		
		
		// Includes the NotNull annotations.
		if (ra.getAmount() == null || ra.getFrequency() == null)
			return false;
		
		
		Double amount = 0.0;
		try {
			amount = Double.parseDouble(ra.getAmount()); // Convert to Double
		} catch (NumberFormatException ne) {
			return false;
		}
		
		// Check if amount contains a value of pounds and pence with an optional decimal point
		if (!ra.getAmount().matches("\\d+(\\.\\d{1,2})?")) 
			return false;
		
		// Convert amount to pence
		double penceAmount = amount * 100;
		
		// Validate according to frequency
		switch (ra.getFrequency()) {
		case WEEK: return true;
		case TWO_WEEK:
			if (penceAmount % 2 > 0)
				return false;
			else
				return true;
		case FOUR_WEEK:
			if (penceAmount % 4 > 0)
				return false;
			else
				return true;
		case MONTH: return true;
		case QUARTER:
			if (penceAmount % 13 > 0)
				return false;
			else
				return true;
			
		case YEAR:
			if (penceAmount % 52 > 0)
				return false;
			else
				return true;
		}

		return false;
	}
}