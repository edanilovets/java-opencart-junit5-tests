package com.opencart.backend.model;

public class UserRegistry {
    public static User getAdmin(){
        return new User("admin", "admin");
    }
}
