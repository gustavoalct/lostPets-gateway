package com.gateway.service;

import com.gateway.client.AccountClient;
import com.gateway.dto.request.CreateAccountRequest;
import com.gateway.dto.request.LoginRequest;
import com.gateway.dto.respose.CreateAccountResponse;
import com.gateway.dto.respose.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountClient accountClient;

    public AccountService(AccountClient accountClient) {
        this.accountClient = accountClient;
    }

    public CreateAccountResponse create(CreateAccountRequest createAccountRequest) {
        return accountClient.createAccount(createAccountRequest);
    }

    public LoginResponse login(LoginRequest loginRequest) {
        return accountClient.loginAccount(loginRequest);
    }

}
