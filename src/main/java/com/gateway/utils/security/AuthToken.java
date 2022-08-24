package com.gateway.utils.security;

import com.gateway.dto.request.LoginRequest;
import com.gateway.dto.respose.LoginResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class AuthToken {

    private String issue = "123456";

    public String generateJwtToken(LoginResponse loginResponse){
        String token = Jwts
                .builder()
                .claim("username", loginResponse.getEmail())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 10800000))
                .signWith(SignatureAlgorithm.HS512, issue.getBytes()).compact();

        return "Bearer " + token;
    }
}
