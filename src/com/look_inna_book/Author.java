package com.look_inna_book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Author {
    private int id;
    private String name;
    private String wiki_link;

    public Author(int id, String name, String wiki_link) {
        this.id = id;
        this.name = name;
        this.wiki_link = wiki_link;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWikiLink() {
        return this.wiki_link;
    }

    public void setWikiLink(String wiki_link) {
        this.wiki_link = wiki_link;
    }

    public void addAuthor(Connection conn) {
        try {
            Statement s = conn.createStatement();
            String sql = "INSERT INTO Authors values('" + this.id + "','"+ this.name + "','" + this.wiki_link + "')";
            s.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean exists(Connection conn){
        try {
            Statement s = conn.createStatement();
            String sql = "SELECT * FROM Authors WHERE id = " + this.id;
            ResultSet results = s.executeQuery(sql);

            return results.next();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean deleteAuthor(Connection conn){
        try {
            Statement s = conn.createStatement();
            String sql = "DELETE FROM Authors WHERE id = " + this.id;
            s.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

}

