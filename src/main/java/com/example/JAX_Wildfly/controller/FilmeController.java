package com.example.JAX_Wildfly.controller;

import com.example.JAX_Wildfly.dao.FilmeDAO;
import com.example.JAX_Wildfly.model.Filmes;
import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("filme")
public class FilmeController {
    @GET
    @Path("create-table")
    @Produces("application/json")
    public Response createTableCinema(){
        FilmeDAO filmeDAO = new FilmeDAO();
        filmeDAO.criaTabelaFilme();
        return Response.ok(new Gson().toJson("Tabela cinema criada com sucesso.")).build();
    }
    @GET
    @Produces("application/json")
    public Response listaFilmes(){
        FilmeDAO filmeDAO = new FilmeDAO();
        List<Filmes> filmes = filmeDAO.listFilmes();
        return Response.ok(new Gson().toJson(filmes)).build();
    }
}
