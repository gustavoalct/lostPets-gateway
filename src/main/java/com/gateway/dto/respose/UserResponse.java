package com.gateway.dto.respose;

import java.util.UUID;

public class UserResponse {

    private UUID id;
    private String token;

    public UserResponse(UUID id, String token) {
        id = id;
        token = token;
    }

    public UUID getId() {
        return id;
    }

    public String getToken() {
        return token;
    }
}
