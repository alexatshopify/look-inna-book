package com.look_inna_book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Publisher {
    private int id;
    private String name;
    private int address_id;
    private String email;
    private int phone_num;
    private String bank_acc;

    public Publisher(int id, String name, int address_id, String email, int phone_num, String bank_acc) {
        this.id = id;
        this.name = name;
        this.address_id = address_id;
        this.email = email;
        this.phone_num = phone_num;
        this.bank_acc = bank_acc;
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

    public int getAddressId() {
        return this.address_id;
    }

    public void setAddressId(int address_id) {
        this.address_id = address_id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNum() {
        return this.phone_num;
    }

    public void setPhoneNum(int phone_num) {
        this.phone_num = phone_num;
    }

    public String getBankAcc() {
        return this.bank_acc;
    }

    public void setBank_acc(String bank_acc){
        this.bank_acc = bank_acc;
    }

    public void addPublisher(Connection conn) {
        try {
            Statement s = conn.createStatement();
            String sql = "INSERT INTO Publishers values('" + this.id + "','"+ this.name + "','" + this.address_id + "','" + this.email + "','" + this.phone_num + "','" + this.bank_acc + "')";
            s.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean exists(Connection conn){
        try {
            Statement s = conn.createStatement();
            String sql = "SELECT * FROM Publishers WHERE id = " + this.id;
            ResultSet results = s.executeQuery(sql);

            return results.next();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean deletePublisher(Connection conn){
        try {
            Statement s = conn.createStatement();
            String sql = "DELETE FROM Publishers WHERE id = " + this.id;
            s.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

}

