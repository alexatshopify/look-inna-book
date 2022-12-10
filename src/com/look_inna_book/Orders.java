package com.look_inna_book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Orders {
    private int id;
    private String status;
    private Date created_at;
    private Date updated_at;
    private int user_id;
    private int delivery_address_id;

    public Orders(int id, String status, Date created_at, Date updated_at, int user_id, int delivery_address_id) {
        this.id = id;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.user_id = user_id;
        this.delivery_address_id = delivery_address_id;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return this.created_at;
    }

    public void setCreatedAt(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdatedAt() {
        return this.updated_at;
    }

    public void setUpdatedAt(Date updated_at) {
        this.updated_at = updated_at;
    }

    public int getUserId() {
        return this.user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    public int getDeliveryAddressId() {
        return this.delivery_address_id;
    }

    public void setDeliveryAddressId(int delivery_address_id) {
        this.delivery_address_id = delivery_address_id;
    }

    public void addOrder(Connection conn) {
        try {
            Statement s = conn.createStatement();
            String sql = "INSERT INTO Orders values('" + this.id + "','"+ this.status + "','" + this.created_at + "','" + this.updated_at + "','" + this.user_id + "','" + this.delivery_address_id + "')";
            s.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean exists(Connection conn){
        try {
            Statement s = conn.createStatement();
            String sql = "SELECT * FROM Orders WHERE id = " + this.id;
            ResultSet results = s.executeQuery(sql);

            return results.next();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean deleteOrder(Connection conn){
        try {
            Statement s = conn.createStatement();
            String sql = "DELETE FROM Orders WHERE id = " + this.id;
            s.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

}

