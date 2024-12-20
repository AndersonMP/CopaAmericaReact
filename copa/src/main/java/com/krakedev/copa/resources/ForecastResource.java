package com.krakedev.copa.resources;

import java.util.ArrayList;

import com.krakedev.copa.bdd.ForecastBDD;
import com.krakedev.copa.entidades.Forecast;
import com.krakedev.copa.excepciones.KrakedevExceptions;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/pronostico")
public class ForecastResource {

	// Endpoint para registrar un pronóstico
	@Path("registrar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registrarPronostico(Forecast pronostico) {
		ForecastBDD pronBDD = new ForecastBDD();

		try {
			pronBDD.registraPronostico(pronostico);
			return Response.ok().build();
		} catch (KrakedevExceptions e) {
			// TODO: handle exception
			e.printStackTrace();
			return Response.serverError().build();
		}

	}

	// Endpoint para recuperar pronóstcio de un usuario
	@Path("recuperar/{cedula}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response recuperarPronostico(@PathParam("cedula") String cedula) {
		ForecastBDD pronBDD = new ForecastBDD();
		ArrayList<Forecast> pronosticos = null;
		try {
			pronosticos = pronBDD.pronosticoUsuario(cedula);
			return Response.ok(pronosticos).build();
		} catch (KrakedevExceptions e) {
			// TODO: handle exception
			e.printStackTrace();
			return Response.serverError().build();
		}

	}

}
