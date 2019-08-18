package com.ing.jersey.rest.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.jersey.rest.NumberValidationException;

@RunWith(MockitoJUnitRunner.class)
public class MathServiceImplTest {

	@InjectMocks
	MathServiceImpl mathService;
	
	
	@Test
	public void testForPositiveNumbers() {
		long valueX = 3;
		long valueY = 5;

		long result = mathService.sum(valueX, valueY);
		assertTrue("Checking sum: ", (result==8));
	}
	
	@Test (expected = NumberValidationException.class)
	public void testForNegativeNumbers() {
		
		long valueX = 3;
		long valueY = -5;
		mathService.sum(valueX, valueY);
	}
	
	@Test (expected = NumberValidationException.class)
	public void testForNumbersGreaterThanThreshold() {
		
		long valueX = 3;
		long valueY = 4000;
		mathService.sum(valueX, valueY);
	}
	
}
