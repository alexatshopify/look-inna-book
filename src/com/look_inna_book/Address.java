package com.look_inna_book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Address {

    // Declare the attributes
    private int id;
    private String line_1;
    private String city;
    private String postal_code;
    private String province;
    private String country;

    // Define the constructor that accepts values for all attributes
    public Address(int id, String line_1, String city, String postal_code, String province, String country) {
        this.id = id;
        this.line_1 = line_1;
        this.city = city;
        this.postal_code = postal_code;
        this.province = province;
        this.country = country;
    }

    // Define the getter and setter methods for each attribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLine_1() {
        return line_1;
    }

    public void setLine_1(String line_1) {
        this.line_1 = line_1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void addAddress(Connection conn) {
        try {
            Statement s = conn.createStatement();
            String sql = "INSERT INTO Addresses values('" + this.id + "','"+ this.line_1 + "','" + this.city + "','" + this.postal_code + "','" + this.province + "','" + this.country + "','" + "')";
            s.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean exists(Connection conn){
        try {
            Statement s = conn.createStatement();
            String sql = "SELECT * FROM Addresses WHERE id=" + this.id;
            ResultSet results = s.executeQuery(sql);

            return results.next();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean deleteAddress(Connection conn){
        try {
            Statement s = conn.createStatement();
            String sql = "DELETE FROM Addresses WHERE id = " + this.id;
            s.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}

