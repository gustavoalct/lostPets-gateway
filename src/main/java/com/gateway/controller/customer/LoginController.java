package com.gateway.controller.customer;

import com.gateway.dto.request.LoginRequest;
import com.gateway.dto.respose.LoginResponse;
import com.gateway.dto.respose.UserResponse;
import com.gateway.service.AccountService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class LoginController {

    @Autowired
    private AccountService accountService;

    public LoginController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse login(@RequestBody LoginRequest loginRequest){
        return accountService.login(loginRequest);
    }

}
