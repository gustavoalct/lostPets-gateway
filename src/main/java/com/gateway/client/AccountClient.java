package com.gateway.client;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gateway.dto.request.CreateAccountRequest;
import com.gateway.dto.request.LoginRequest;
import com.gateway.dto.respose.CreateAccountResponse;
import com.gateway.dto.respose.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;

@Component
public class AccountClient {

    @Value("${lostpets.url}")
    private String URL;
    private String ACCOUNT = "account";
    private String CREATE = "create";
    private String LOGIN = "login";

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public AccountClient(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public CreateAccountResponse createAccount(CreateAccountRequest createAccountRequest) {
//        HttpHeaders headers = generateAuthenticatedHeaders();  // pegando o token
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        String url = UriComponentsBuilder.fromUriString(URL)
                .pathSegment(ACCOUNT)
                .pathSegment(CREATE)
                .build().toString();
        try {
            HttpEntity<CreateAccountRequest> entity = new HttpEntity<>(createAccountRequest);
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
            ObjectMapper mapper = new ObjectMapper();

            return mapper.readValue(responseEntity.getBody(), new TypeReference<CreateAccountResponse>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    public LoginResponse loginAccount(LoginRequest loginRequest) {
//        HttpHeaders headers = generateAuthenticatedHeaders();  // pegando o token
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        String url = UriComponentsBuilder.fromUriString(URL)
                .pathSegment(ACCOUNT)
                .pathSegment(LOGIN)
                .build().toString();
        try {
            HttpEntity<LoginRequest> entity = new HttpEntity<>(loginRequest);
            ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
            ObjectMapper mapper = new ObjectMapper();

            return mapper.readValue(responseEntity.getBody(), new TypeReference<LoginResponse>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
