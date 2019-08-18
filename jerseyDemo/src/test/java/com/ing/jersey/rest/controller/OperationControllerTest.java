package com.ing.jersey.rest.controller;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.ws.rs.core.Response;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.jersey.rest.NumberValidationException;
import com.ing.jersey.rest.service.MathService;

@RunWith(MockitoJUnitRunner.class)
public class OperationControllerTest {

	@InjectMocks
	private OperationController controller;

	@Mock
	private MathService mathService;


	@Test
	public void testSumWithValildInput() {
		final long valueX = 10;
		final long valueY = 15;
		final long result = 25;

		when(mathService.sum(anyLong(), anyLong())).thenReturn(result);
		final Response response = controller.sum(valueX, valueY);

		assertTrue("Comparing result", ((String)response.getEntity()).contains("" + result));
		assertTrue("Comparing result", response.getStatus() == 200);
		verify(mathService, times(1)).sum(anyLong(), anyLong());

	}
	
	@Test(expected = NumberValidationException.class)
	public void testSumForNegaiveInput() {
		final long valueX = -10; 
		final long valueY = 15; 
		doThrow(new NumberValidationException("Negative numbers not allowed.")).when(mathService).sum(valueX, valueY);
		
		controller.sum(valueX, valueY);
	}
	
	@Test(expected = NumberValidationException.class)
	public void testSumForInputGreaterThanThreshold() {
		final long valueX = 4000; 
		final long valueY = 15; 
		doThrow(new NumberValidationException("Number can not be greater than 1000.")).when(mathService).sum(valueX, valueY);
		
		controller.sum(valueX, valueY);
	}

}
