package com.example.ApiMerkMobil.security;

import lombok.Getter;

@Getter
public class AuthRequest {
    // Getter & Setter
    private String username;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}