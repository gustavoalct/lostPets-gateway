package com.gateway.controller.customer;

import com.gateway.dto.request.CreateAccountRequest;
import com.gateway.dto.respose.CreateAccountResponse;
import com.gateway.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private AccountService accountService;

    public CustomerController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody CreateAccountRequest createAccountRequest) {
        CreateAccountResponse accountRespose = accountService.create(createAccountRequest);
        return new ResponseEntity(accountRespose, HttpStatus.CREATED);
    }

    @PostMapping("/create/login")
    @ResponseStatus(HttpStatus.CREATED)
    public void createLogin (){}
}
