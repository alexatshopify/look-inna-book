package com.look_inna_book;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Users {

    // Declare the attributes
    private int id;
    private String username;
    private String password;
    private String name;
    private int preferred_address_id;
    private Date created_at;

    // Define a constructor that takes values for all attributes as arguments
    public Users(int id, String username, String password, String name, int preferred_address_id, Date created_at) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.preferred_address_id = preferred_address_id;
        this.created_at = created_at;
    }

    // Define the getter and setter methods for each attribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPreferredAddressId() {
        return preferred_address_id;
    }

    public void setPreferredAddressId(int preferred_address_id) {
        this.preferred_address_id = preferred_address_id;
    }

    public Date getCreatedAt() {
        return created_at;
    }

    public void setCreated_at(Date created_at){
        this.created_at = created_at;
    }

    public void addUser(Connection conn) {
        try {
            Statement s = conn.createStatement();
            String sql = "INSERT INTO Users values('" + this.id + "','"+ this.username + "','" + this.password + "','" + this.name + "','" + this.preferred_address_id + "','" + this.created_at + "')";
            s.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean exists(Connection conn){
        try {
            Statement s = conn.createStatement();
            String sql = "SELECT * FROM Users WHERE username = '" + this.username + "' AND password = '" + this.password + "'";
            ResultSet results = s.executeQuery(sql);

            return results.next();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean deleteUser(Connection conn){
        try {
            Statement s = conn.createStatement();
            String sql = "DELETE FROM Users WHERE id = " + this.id;
            s.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
