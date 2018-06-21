package com.company.benefits_amount_validator.controller;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({FIELD, CONSTRUCTOR, TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = RegularAmountValidator.class)
public @interface ValidateRegularAmount {

	String message() default "Partially Invalid Amount";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}