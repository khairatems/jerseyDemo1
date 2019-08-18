/**
 * 
 */
package com.ing.jersey.rest;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Class to handle exception across appilcation.
 * 
 * @author MontyLenovo @
 */

@Provider
public class CustomExceptionHandler {

	@Provider
	public static class BadRequestExceptionMapper implements ExceptionMapper<NumberValidationException> {

		@Override
		public Response toResponse(NumberValidationException exception) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("Code:" + Response.Status.BAD_REQUEST + ":" + exception.getMessage()).build();
		}
	}

	@Provider
	public static class GenericExceptionMapper implements ExceptionMapper<Exception> {

		@Override
		public Response toResponse(Exception exception) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("Code:" + Response.Status.INTERNAL_SERVER_ERROR + ":" + "Something really bad happened ...")
					.build();
		}
	}

}
