package com.example.JAX_Wildfly.controller;

import com.example.JAX_Wildfly.dao.CinemaDAO;
import com.example.JAX_Wildfly.model.Cinema;
import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("cinema")
public class CinemaController {
    @GET
    @Path("/create-table")
    @Produces("application/json")
    public Response createTableCinema(){
        CinemaDAO cinemaDAO = new CinemaDAO();
        cinemaDAO.criaTabelaCinema();
        return Response.ok(new Gson().toJson("Tabela cinema criada com sucesso.")).build();
    }
    @GET
    @Produces("application/json")
    public Response listaCinema(){
        CinemaDAO cinemaDAO = new CinemaDAO();
        List<Cinema> cinemas = cinemaDAO.listCinema();
        return Response.ok(new Gson().toJson(cinemas)).build();
    }
}
