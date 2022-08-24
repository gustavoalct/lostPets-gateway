package com.gateway.service;

import com.gateway.client.AccountClient;
import com.gateway.dto.request.CreateAccountRequest;
import com.gateway.dto.request.LoginRequest;
import com.gateway.dto.respose.CreateAccountResponse;
import com.gateway.dto.respose.LoginResponse;
import com.gateway.dto.respose.UserResponse;
import com.gateway.utils.security.AuthToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountClient accountClient;
    @Autowired
    private AuthToken authToken;
    public AccountService(AccountClient accountClient, AuthToken authToken) {
        this.accountClient = accountClient;
        this.authToken = authToken;
    }

    public CreateAccountResponse create(CreateAccountRequest createAccountRequest) {
        return accountClient.createAccount(createAccountRequest);
    }

    public UserResponse login(LoginRequest loginRequest) {

        LoginResponse loginResponse = accountClient.loginAccount(loginRequest);
        String token = authToken.generateJwtToken(loginResponse);
        UserResponse userResponse = new UserResponse(loginResponse.getId(), token);
        return userResponse;
    }

}
