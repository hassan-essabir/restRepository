package com.formation.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloRessource {
	@GET
	@Path("/world/{param}")
	@Produces("text/plain")
	public String getMessage(@PathParam("param") String msg) {
		return "Hello service REST " + msg;
	}

//	@SuppressWarnings("unchecked")
//	@GET
//	@Path("/equipements")
//	@Produces({MediaType.APPLICATION_XML})
//	public List<Equipement> getXML() {
//		return (List<Equipement>) new Equipement("HP","Pavillon");
//	}
}
