package com.ing.jersey.rest;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.ing.jersey.rest.service.MathService;
import com.ing.jersey.rest.service.MathServiceImpl;

public class NumberValidatinException {
	MathService mathService;

	@Before
	public void init() {
		mathService = new MathServiceImpl();
	}

	@Test
	public void testForNegativeInput() {
		try {
			mathService.sum(-10, 90);
			fail("expected NumberValidationException");
		} catch (Exception invalidNumberException) {
			assertTrue("Checking exception type", (invalidNumberException instanceof NumberValidationException));
			assertTrue("Checking message of throwable",
					invalidNumberException.getMessage().contains("Negative numbers not allowed"));
		}
	}

	@Test
	public void testForInputGreaterThanThreshold() {
		try {
			mathService.sum(1110, 90);
			fail("expected NumberValidationException");
		} catch (Exception invalidNumberException) {
			assertTrue("Checking exception type", (invalidNumberException instanceof NumberValidationException));
			assertTrue("Checking message of throwable",
					invalidNumberException.getMessage().contains("Number can not be greater than 1000"));
		}
	}

}
