package com.example.JAX_Wildfly.dao;

import com.example.JAX_Wildfly.factory.ConnectionFactory;
import com.example.JAX_Wildfly.model.Cinema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CinemaDAO {
    private Connection connection;

    public CinemaDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }

    public void criaTabelaCinema(){
        String sql = "CREATE TABLE IF NOT EXISTS cinemas(" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "titulo VARCHAR(100) NOT NULL," +
                "endereco VARCHAR(255) NOT NULL);";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
            stmt.close();

            System.out.println("Tabela cinemas criada");
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    public List<Cinema> listCinema(){
        String sql = "SELECT * FROM cinemas";

        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            List<Cinema> cinemas = new ArrayList<>();
            Cinema cinema;

            while(resultSet.next()){
                cinema = new Cinema();
                cinema.setId(resultSet.getLong("id"));
                cinema.setTitulo(resultSet.getString("titulo"));
                cinema.setEndereco(resultSet.getString("endereco"));

               cinemas.add(cinema);
            }
            return cinemas;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    public Cinema buscaCinemaID(long id){
        String sql = "SELECT * FROM cinemas WHERE id = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);

            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()){
                Cinema cinema = new Cinema();
                cinema.setId(resultSet.getLong("id"));
                cinema.setTitulo(resultSet.getString("titulo"));
                cinema.setEndereco(resultSet.getString("endereco"));

                return cinema;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        } finally {
            if (connection != null){
                try{
                    connection.close();
                }catch (SQLException throwables){
                    throwables.printStackTrace();
                }
            }
        }
        return null;
    }
}
