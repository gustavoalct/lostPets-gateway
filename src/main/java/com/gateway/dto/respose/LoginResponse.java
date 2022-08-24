package com.gateway.dto.respose;

import java.util.UUID;

public class LoginResponse {

    private UUID id;
    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public UUID getId() {
        return id;
    }
}
