package com.krakedev.copa.resources;

import com.krakedev.copa.bdd.CountryBDD;
import com.krakedev.copa.entidades.Country;
import com.krakedev.copa.excepciones.KrakedevExceptions;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/equipo")
public class CountryResource {

	// Endpoint para crear un nuevo usuario
	@Path("registrar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registrarEquipo(Country equipo) {
		CountryBDD counBDD = new CountryBDD();
		
		try {
			counBDD.registraEquipo(equipo);
			return Response.ok().build();
		} catch (KrakedevExceptions e) {
			// TODO: handle exception
			e.printStackTrace();
			return Response.serverError().build();
		}
		
	}

}
