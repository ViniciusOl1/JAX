package com.example.JAX_Wildfly.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/gerenciador?useSSL=false&useTimezone=true&serverTimezone=UTC", "root", "root");
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
