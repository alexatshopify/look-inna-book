package com.look_inna_book;
import java.sql.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Starting program");
        System.out.println("trying to connect");
        Connection conn = TryConnection.connect();

        System.out.println("Database initialized.");
    }
}
