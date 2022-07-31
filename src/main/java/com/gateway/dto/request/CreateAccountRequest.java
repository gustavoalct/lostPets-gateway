package com.gateway.dto.request;

public class CreateAccountRequest {

    private String userName;
    private String email;
    private String password;


    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
