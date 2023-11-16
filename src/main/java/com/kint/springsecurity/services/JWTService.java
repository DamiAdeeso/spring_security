package com.kint.springsecurity.services;

import com.kint.springsecurity.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashMap;
import java.util.Map;

public interface JWTService {
    String extractUserName(String token);

    String generateToken(UserDetails userDetails);

    boolean isTokenValid (String token, UserDetails userDetails);


    public String generateRefreshToken(Map<String, Object> extraClaims, UserDetails userDetails);
}