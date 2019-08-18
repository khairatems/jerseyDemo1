/**
 * 
 */
package com.ing.jersey.rest.controller;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.ing.jersey.rest.service.MathService;

/**
 * Controller to handler requests.
 * 
 * @author MontyLenovo
 *
 */

@Path("/api")
public class OperationController {

	@Autowired
	private MathService mathService;

	@GET
	@Path("/sum")
	@Produces(MediaType.APPLICATION_JSON)
	public Response sum(@DefaultValue("0") @QueryParam(value = "x") long valueX, 
					@DefaultValue("0") @QueryParam(value = "y") long valueY) {

		final long result = mathService.sum(valueX, valueY);
		
		return Response.ok().entity("Sum = " + (Long) result).build();
	}
	
}
