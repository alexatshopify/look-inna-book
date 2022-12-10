package com.look_inna_book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Written_by {
    private String book_isbn;
    private int auth_id;

    public Written_by(String book_isbn, int auth_id) {
        this.book_isbn = book_isbn;
        this.auth_id = auth_id;
    }

    public String getBookIsbn() {
        return this.book_isbn;
    }

    public void setBookIsbn(String book_isbn) {
        this.book_isbn = book_isbn;
    }

    public int getAuthId() {
        return this.auth_id;
    }

    public void setAuthId(int auth_id) {
        this.auth_id = auth_id;
    }

    public void addWrittenBy(Connection conn) {
        try {
            Statement s = conn.createStatement();
            String sql = "INSERT INTO Written_by values('" + this.book_isbn + "','"+ this.auth_id + "')";
            s.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean exists(Connection conn){
        try {
            Statement s = conn.createStatement();
            String sql = "SELECT * FROM Written_by WHERE book_isbn = '" + this.book_isbn + "' AND auth_id = " + this.auth_id;
            ResultSet results = s.executeQuery(sql);

            return results.next();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean deleteWrittenBy(Connection conn){
        try {
            Statement s = conn.createStatement();
            String sql = "DELETE FROM Written_by WHERE book_isbn = '" + this.book_isbn + "' AND auth_id = " + this.auth_id;
            s.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

}