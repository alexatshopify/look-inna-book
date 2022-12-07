package com.look_inna_book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TryConnection {
    public TryConnection(){

    }

    public static java.sql.Connection connect() {
        java.sql.Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/postgres", "alexdjordjevic", "");
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
}
