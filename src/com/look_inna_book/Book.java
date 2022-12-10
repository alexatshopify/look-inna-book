package com.look_inna_book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Book {
    private String isbn;
    private String title;
    private int publisher_id;
    private int num_pages;
    private float price;
    private int num_in_stock;
    private float publisher_percentage;

    public Book(String isbn, String title, int publisher_id, int num_pages, float price, int num_in_stock, float publisher_percentage) {
        this.isbn = isbn;
        this.title = title;
        this.publisher_id = publisher_id;
        this.num_pages = num_pages;
        this.price = price;
        this.num_in_stock = num_in_stock;
        this.publisher_percentage = publisher_percentage;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublisherId() {
        return this.publisher_id;
    }

    public void setPublisherId(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public int getNumPages() {
        return this.num_pages;
    }

    public void setNumPages(int num_pages) {
        this.num_pages = num_pages;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNumInStock() {
        return this.num_in_stock;
    }

    public void setNumInStock(int num_in_stock) {
        this.num_in_stock = num_in_stock;
    }

    public float getPublisherPercentage() {
        return this.publisher_percentage;
    }

    public void setPublisherPercentage(float publisher_percentage) {
        this.publisher_percentage = publisher_percentage;
    }

    public void addBook(Connection conn) {
        try {
            Statement s = conn.createStatement();
            String sql = "INSERT INTO Books values('" + this.isbn + "','"+ this.title + "','" + this.publisher_id + "','" + this.num_pages + "','" + this.price + "','" + this.num_in_stock + "','" + this.publisher_percentage + "')";
            s.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean exists(Connection conn){
        try {
            Statement s = conn.createStatement();
            String sql = "SELECT * FROM Books WHERE isbn = '" + this.isbn + "'";
            ResultSet results = s.executeQuery(sql);

            return results.next();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean deleteBook(Connection conn){
        try {
            Statement s = conn.createStatement();
            String sql = "DELETE FROM Books WHERE isbn = " + this.isbn;
            s.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}

