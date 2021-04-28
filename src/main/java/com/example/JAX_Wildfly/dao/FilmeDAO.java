package com.example.JAX_Wildfly.dao;

import com.example.JAX_Wildfly.factory.ConnectionFactory;
import com.example.JAX_Wildfly.model.Cinema;
import com.example.JAX_Wildfly.model.Filmes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmeDAO {
    private Connection connection;

    public FilmeDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void criaTabelaFilme(){
        String sql = "CREATE TABLE IF NOT EXISTS filmes(" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "titulo VARCHAR(100) NOT NULL," +
                "categoria VARCHAR(255) NOT NULL," +
                "descricao VARCHAR(100) NOT NULL,"+
                "idCinema INT(11) NOT NULL,"+
                "CONSTRAINT fk_idCinema FOREIGN KEY (idCinema)"+
                "REFERENCES cinemas(id));";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
            stmt.close();

            System.out.println("Tabela filmes criada com sucesso");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public List<Filmes> listFilmes(){
        String sql = "SELECT * FROM filmes";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            List<Filmes> filmes = new ArrayList<>();
            Filmes film = new Filmes();

            while(resultSet.next()){
                film.setId(resultSet.getLong("id"));
                film.setTitulo(resultSet.getString("titulo"));
                film.setCategoria(resultSet.getString("categoria"));
                film.setDuracao(resultSet.getString("duracao"));

                CinemaDAO cinemaDAO = new CinemaDAO();
                Cinema cinema = cinemaDAO.buscaCinemaID(resultSet.getInt("idCinema"));
                film.setCinema(cinema);
                filmes.add(film);
            }
            return filmes;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }

    }
}
