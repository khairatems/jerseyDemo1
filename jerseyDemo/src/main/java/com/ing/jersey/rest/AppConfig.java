/**
 * 
 */
package com.ing.jersey.rest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * Application class to enable register for component scan.
 * 
 * @author MontyLenovo
 *
 */
@ApplicationPath("/")
public class AppConfig extends ResourceConfig {

	public AppConfig() {
		packages("com.ing.jersey.rest");
	}

}
