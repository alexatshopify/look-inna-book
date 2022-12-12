package com.look_inna_book;
import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void build_table(String sql, Connection conn) {
        try {
            Statement s = conn.createStatement();
            ResultSet result = s.executeQuery(sql);
            ResultSetMetaData meta_data = result.getMetaData();

            int columns_number = meta_data.getColumnCount();

            System.out.println("================================================");
            while (result.next()) {
                for(int i = 1 ; i < columns_number; i++) {
                    System.out.print(meta_data.getColumnName(i) + ": " + result.getString(i) + ", ");
                }
                System.out.println(meta_data.getColumnName(columns_number) + ": " + result.getString(columns_number));
            }
            System.out.println("================================================");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void query_books(String query_string, Connection conn, int query_by){
        String sql = "";
        switch (query_by){
            case 1: //title
                sql = "SELECT * FROM Book WHERE title LIKE '" + query_string + "'";
                break;
            case 2: //genre
                sql = "SELECT * FROM Book JOIN Genre ON Book.isbn = Genre.isbn WHERE Genre.genre_name LIKE '" + query_string + "'";
                break;
            case 3: //author
                sql = "SELECT * FROM Book JOIN Written_by ON Book.isbn = Written_by.book_isbn WHERE Written_by.book_isbn = (SELECT id FROM Author WHERE name LIKE '" + query_string + "' LIMIT 1";
                break;
            case 4: //publisher
                sql = "SELECT * FROM Book JOIN Publisher ON Book.publisher_id = Publisher.id WHERE Publisher.name LIKE '" + query_string + "'";
                break;
            case 5: //all books
                sql = "SELECT * FROM Book LIMIT 100";
                break;
        }
        build_table(sql, conn);
    }

    public static void main(String[] args) {
        System.out.println("Starting program");
        System.out.println("trying to connect");
        Connection conn = TryConnection.connect();

        System.out.println("Database initialized.");


        Scanner input = new Scanner(System.in);
        int choice = 0;
        String query_string = "";

        System.out.println("What are you?");
        System.out.println("1. Owner");
        System.out.println("2. User");
        choice = input.nextInt();
        switch (choice){
            case 1:
                System.out.println("Welcome to your bookstore! What would you like to do?");
                System.out.println("1. Display books");
                System.out.println("2. Display orders");
                System.out.println("3. Add books");
                System.out.println("4. Exit");
                choice = input.nextInt();
                break;
            case 2:
                while (choice != 4) {
                    System.out.println("Welcome to the bookstore! What would you like to do?");
                    System.out.println("1. Browse books");
                    System.out.println("2. Add book to order");
                    System.out.println("3. Check out");
                    System.out.println("4. Exit");

                    choice = input.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.println("How would you like to browse?");
                            System.out.println("1. By Title");
                            System.out.println("2. By Genre");
                            System.out.println("3. By Author");
                            System.out.println("4. By Publisher");
                            System.out.println("5. By Display all books");
                            choice = input.nextInt();
                            switch (choice) {
                                case 1:
                                    System.out.println("Enter a title: ");
                                    input.nextLine();
                                    query_string = input.nextLine();
                                    query_books(query_string, conn, 1);
                                    break;
                                case 2:
                                    System.out.println("Enter a genre: ");
                                    input.nextLine();
                                    query_string = input.nextLine();
                                    query_books(query_string, conn, 2);
                                    break;
                                case 3:
                                    System.out.println("Enter an author name: ");
                                    input.nextLine();
                                    query_string = input.nextLine();
                                    query_books(query_string, conn, 3);
                                    break;
                                case 4:
                                    System.out.println("Enter a publisher name: ");
                                    input.nextLine();
                                    query_string = input.nextLine();
                                    query_books(query_string, conn, 4);
                                    break;
                                case 5:
                                    query_books(query_string, conn, 5);
                                    break;
                            }
                            break;
                        case 2:
                            System.out.println("Enter the isbn of the book you want to add to your order: ");
                            input.nextLine();
                            query_string = input.nextLine();
                            // add the book to the order
                            break;
                        case 3:
                            // code to check out
                            break;
                        case 4:
                            System.out.println("Goodbye! Thank you for visiting the bookstore.");
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                }
                break;
        }
    }
}
