package com.example.ApiMerkMobil.security;

public class AuthResponse {
    private final String bearer;

    public AuthResponse(String token) {
        this.bearer = token;
    }

    public String getToken() {
        return bearer;
    }
}