package com.wipro.mw;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.camel.Exchange;

@Path("/")
public class RestServiceResource {

	@Context
	private UriInfo uriInfo;

	@GET
	@Path("/{country}/")
	@Produces("text/plain")
	public void getCapitalByState(@PathParam("country") String country) {
		System.out.println("RESTfull services is called:" + country);

	}
}
