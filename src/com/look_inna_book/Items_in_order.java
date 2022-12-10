package com.look_inna_book;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Items_in_order {
    private String book_isbn;
    private int order_id;
    private int count;

    public Items_in_order(String book_isbn, int order_id, int count) {
        this.book_isbn = book_isbn;
        this.order_id = order_id;
        this.count = count;
    }

    public String getBookIsbn() {
        return this.book_isbn;
    }

    public void setBookIsbn(String book_isbn) {
        this.book_isbn = book_isbn;
    }

    public int getOrderId() {
        return this.order_id;
    }

    public void setOrderId(int order_id) {
        this.order_id = order_id;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void addItem(Connection conn) {
        try {
            Statement s = conn.createStatement();
            String sql = "INSERT INTO Items_in_order values('" + this.book_isbn + "','" + this.order_id + "','" + this.count + "')";
            s.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean exists(Connection conn) {
        try {
            Statement s = conn.createStatement();
            String sql = "SELECT * FROM Items_in_order WHERE book_isbn = '" + this.book_isbn + "' AND order_id = " + this.order_id;
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean deleteItem(Connection conn){
        try {
            Statement s = conn.createStatement();
            String sql = "DELETE FROM Items_in_order WHERE book_isbn = '" + this.book_isbn + "' AND order_id = " + this.order_id;
            s.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

}
