package com.company.benefits_amount_validator.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

import com.company.benefits_amount_validator.model.Frequency;
import com.company.benefits_amount_validator.model.RegularAmount;

public class RegularAmountUnitTest {

	private Validator validator;
	private RegularAmount regularAmount;

	@Before
	public void init() {

		ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
		this.validator = vf.getValidator();

	}

	@Before
	public void setUp() {
		regularAmount = new RegularAmount();
	}

	/**
	 * Rigorous Test :-)
	 */
	@Test
	public void shouldAnswerWithTrue() {
		assertTrue(true);
	}

	
	/**
	 * Check amount of more than 2 decimal digits is not allowed
	 */
	@Test
	public void moreThanTwoDecimalDigits() {
		
		regularAmount.setFrequency(Frequency.WEEK);
		regularAmount.setAmount("57.935");
		Set<ConstraintViolation<RegularAmount>> violations = validator.validate(regularAmount);
		printViolations(violations);
		assertEquals(1, violations.size());
	}

	/**
	 * Check amount is not a number
	 */
	@Test
	public void notANumber() {
		regularAmount.setFrequency(Frequency.WEEK);
		regularAmount.setAmount("testAmount");
		Set<ConstraintViolation<RegularAmount>> violations = validator.validate(regularAmount);
		System.out.println("Check amount is not a number violations:");
		printViolations(violations);
		assertEquals(1, violations.size());
	}
	
	/**
	 * Check frequency is not null
	 */
	@Test
	public void frequencyNotNull() {
		regularAmount.setFrequency(null);
		regularAmount.setAmount("60.00");
		Set<ConstraintViolation<RegularAmount>> violations = validator.validate(regularAmount);
		System.out.println("Check frequency is not null violations:");
		printViolations(violations);
		assertEquals(2, violations.size());
	}
	
	/**
	 * Check frequency is not null
	 */
	@Test
	public void amountNotNull() {
		regularAmount.setFrequency(Frequency.WEEK);
		regularAmount.setAmount(null);
		Set<ConstraintViolation<RegularAmount>> violations = validator.validate(regularAmount);
		System.out.println("Check amount is not null violations:");
		printViolations(violations);
		assertEquals(2, violations.size());
	}
	
	/**
	 * Check frequency is not null
	 */
	@Test
	public void amountNull() {
		regularAmount.setFrequency(Frequency.WEEK);
		regularAmount.setAmount("0.00");
		Set<ConstraintViolation<RegularAmount>> violations = validator.validate(regularAmount);
		System.out.println("Check amount is not null violations:");
		//printViolations(violations);
		//assertEquals(, violations.size());
		assertTrue(violations.isEmpty());
	}

	/**
	 * Check WEEK amount in full pounds is accepted
	 */
	@Test
	public void fullPoundsAmount() {
		regularAmount.setFrequency(Frequency.WEEK);
		regularAmount.setAmount("57");
		Set<ConstraintViolation<RegularAmount>> violations = validator.validate(regularAmount);
		assertTrue(violations.isEmpty());
	}
	
	/**
	 * Check any WEEK amount is accepted
	 */
	@Test
	public void testWeekAmount() {
		regularAmount.setFrequency(Frequency.WEEK);
		regularAmount.setAmount("57.93");
		Set<ConstraintViolation<RegularAmount>> violations = validator.validate(regularAmount);
		assertTrue(violations.isEmpty());
	}

	/**
	 * Check TWO_WEEK amount that is divisible by two is accepted
	 */
	@Test
	public void testTwoWeekAmount() {
		regularAmount.setFrequency(Frequency.TWO_WEEK);
		regularAmount.setAmount("115.80");
		Set<ConstraintViolation<RegularAmount>> violations = validator.validate(regularAmount);
		assertTrue(violations.isEmpty());
	}
	
	/**
	 * Check TWO_WEEK amount that is not divisible by two is flagged
	 */
	@Test
	public void twoWeekAmountNotDivisible() {
		regularAmount.setFrequency(Frequency.TWO_WEEK);
		regularAmount.setAmount("115.81");
		Set<ConstraintViolation<RegularAmount>> violations = validator.validate(regularAmount);
		System.out.println("Check TWO_WEEK amount that is not divisible by two is flagged violations:");
		printViolations(violations);
		assertEquals(1, violations.size());
	}

	/**
	 * Check FOUR_WEEK amount that is divisible to a whole week value is accepted
	 */
	@Test
	public void testFourWeekAmountDivisible() {
		regularAmount.setFrequency(Frequency.FOUR_WEEK);
		regularAmount.setAmount("231.60");
		Set<ConstraintViolation<RegularAmount>> violations = validator.validate(regularAmount);
		assertTrue(violations.isEmpty());
	}
	
	/**
	 * Check FOUR_WEEK amount that is NOT divisible to a whole week value is NOT accepted
	 */
	@Test
	public void testFourWeekAmountNotDivisible() {
		regularAmount.setFrequency(Frequency.FOUR_WEEK);
		regularAmount.setAmount("289.50");
		Set<ConstraintViolation<RegularAmount>> violations = validator.validate(regularAmount);
		System.out.println("Check FOUR_WEEK amount that is NOT divisible to a whole week value is NOT accepted violations:");
		printViolations(violations);
		assertEquals(1, violations.size());
	}
	
	/**
	 * Check MONTH amount is accepted
	 */
	@Test
	public void testMonthAmountIsAccepted() {
		regularAmount.setFrequency(Frequency.MONTH);
		regularAmount.setAmount("289.50");
		Set<ConstraintViolation<RegularAmount>> violations = validator.validate(regularAmount);
		assertTrue(violations.isEmpty());
	}
	
	/**
	 * Check QUARTER amount that is divisible to a whole week value is accepted
	 */
	@Test
	public void testQuarterIsDivisible() {
		regularAmount.setFrequency(Frequency.QUARTER);
		regularAmount.setAmount("752.70");
		Set<ConstraintViolation<RegularAmount>> violations = validator.validate(regularAmount);
		assertTrue(violations.isEmpty());
	}
	
	/**
	 * Check QUARTER amount that is NOT divisible to a whole week value is NOT accepted
	 */
	@Test
	public void testQuarterIsNotDivisible() {
		regularAmount.setFrequency(Frequency.QUARTER);
		regularAmount.setAmount("810.60");
		Set<ConstraintViolation<RegularAmount>> violations = validator.validate(regularAmount);
		System.out.println("Check QUARTER amount that is NOT divisible to a whole week value is NOT accepted violations:");
		printViolations(violations);
		assertEquals(1, violations.size());
	}
	
	/**
	 * Check YEAR amount that is divisible to a whole week value is accepted
	 */
	@Test
	public void testYearIsDivisible() {
		regularAmount.setFrequency(Frequency.YEAR);
		regularAmount.setAmount("3010.80");
		Set<ConstraintViolation<RegularAmount>> violations = validator.validate(regularAmount);
		assertTrue(violations.isEmpty());
	}
	
	/**
	 * Check YEAR amount that is NOT divisible to a whole week value is NOT accepted
	 */
	@Test
	public void testYearIsNotDivisible() {
		regularAmount.setFrequency(Frequency.QUARTER);
		regularAmount.setAmount("3068.7");
		Set<ConstraintViolation<RegularAmount>> violations = validator.validate(regularAmount);
		System.out.println("Check QUARTER amount that is NOT divisible to a whole week value is NOT accepted violations:");
		printViolations(violations);
		assertEquals(1, violations.size());
	}
	
	
	/**
	 * Method to print violations message and the test case they come from to console
	 * @param constraintViolations
	 */
	private void printViolations(Set<ConstraintViolation<RegularAmount>> constraintViolations) {

	    for (ConstraintViolation<RegularAmount> violation : constraintViolations) {
    
	      String message = violation.getMessage();
	      System.out.println("Found constraint violation. Message: " + message);
	    }
	  }
}
