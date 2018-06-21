package com.company.benefits_amount_validator.model;

import javax.validation.constraints.NotNull;

import com.company.benefits_amount_validator.controller.ValidateRegularAmount;

/**
 * Class for building a regular amount object containing the frequency and corresponding amount 
 * supplied by the client.
 * @author Lutz Lemmer
 *
 */
@ValidateRegularAmount
public class RegularAmount {

	@NotNull(message = "Frequency is mandatory")
	private Frequency frequency;
	
	@NotNull(message = "Regular Amount is mandatory")
	private String amount;
	
	
	public RegularAmount() {
		super();	
	}
	
	public RegularAmount(Frequency frequency, String amount) {
		super();
		this.frequency = frequency;
		this.amount = amount;
	}

	public Frequency getFrequency() {
		return frequency;
	}

	public void setFrequency(Frequency frequency) {
		this.frequency = frequency;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
}
