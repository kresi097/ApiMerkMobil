package com.example.ApiMerkMobil.controller;

import com.example.ApiMerkMobil.security.AuthRequest;
import com.example.ApiMerkMobil.security.AuthResponse;
import com.example.ApiMerkMobil.service.JWTUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    // Endpoint login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        // Validasi kredensial demo
        if("admin".equals(authRequest.getUsername()) && "password".equals(authRequest.getPassword())) {
            String token = JWTUtil.generateToken(authRequest.getUsername());
            return ResponseEntity.ok(new AuthResponse(token));
        }
        return ResponseEntity.status(401).build();
    }
}
