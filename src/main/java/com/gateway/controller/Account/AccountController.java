package com.gateway.controller.Account;

import com.gateway.dto.request.CreateAccountRequest;
import com.gateway.dto.respose.CreateAccountResponse;
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
public class AccountController {

    @Autowired
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody CreateAccountRequest createAccountRequest) {
        CreateAccountResponse accountRespose = accountService.create(createAccountRequest);
        return new ResponseEntity(accountRespose, HttpStatus.CREATED);
    }
}
