package com.look_inna_book;

import java.util.Date;

public class User {
    protected String id;
    protected String username;
    protected String name;
    protected String password;
    protected Date created_at;

    String getId() {
        return this.id;
    }

    String getUsername() {
        return this.username;
    }

    String getName() {
        return this.name;
    }

    Date getCreated_at() {
        return this.created_at;
    }

    boolean checkPassword(String pw) {
        if(password.equals(pw)){
            return true;
        }
        return false;
    }
}