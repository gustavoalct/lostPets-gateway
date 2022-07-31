package com.gateway.controller.Account;

import com.gateway.dto.request.LoginRequest;
import com.gateway.dto.respose.LoginResponse;
import com.gateway.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class LoginController {

    @Autowired
    private AccountService accountService;

    public LoginController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequest loginRequest){
        LoginResponse loginResponse = accountService.login(loginRequest);
        return new ResponseEntity<>(loginRequest, HttpStatus.ACCEPTED);
    }


}
