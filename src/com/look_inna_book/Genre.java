package com.look_inna_book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Genre {
    private String book_isbn;
    private String genre_name;

    public Genre(String book_isbn, String genre_name) {
        this.book_isbn = book_isbn;
        this.genre_name = genre_name;
    }

    public String getBookIsbn() {
        return this.book_isbn;
    }

    public void setBookIsbn(String book_isbn) {
        this.book_isbn = book_isbn;
    }

    public String getGenreName() {
        return this.genre_name;
    }

    public void setGenreName(String genre_name) {
        this.genre_name = genre_name;
    }

    public void addGenre(Connection conn) {
        try {
            Statement s = conn.createStatement();
            String sql = "INSERT INTO Genres values('" + this.book_isbn + "','"+ this.genre_name + "')";
            s.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean exists(Connection conn){
        try {
            Statement s = conn.createStatement();
            String sql = "SELECT * FROM Genres WHERE book_isbn = '" + this.book_isbn + "' AND genre_name = '" + this.genre_name + "'";
            ResultSet results = s.executeQuery(sql);

            return results.next();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean deleteGenre(Connection conn){
        try {
            Statement s = conn.createStatement();
            String sql = "DELETE FROM Genres WHERE book_isbn = '" + this.book_isbn + "' AND genre_name = '" + this.genre_name + "'";
            s.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }


}
