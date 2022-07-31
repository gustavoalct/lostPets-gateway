package com.gateway.dto.respose;

import java.util.UUID;

public class CreateAccountResponse {

    private UUID id;
    private String email;

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
