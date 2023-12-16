package com.example.amine_mbarek_lsi3_mesure_glycemie.model;

public class User {
    private String username;
    private String password;

    public User(String userName, String password) {
        this.username = userName;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

