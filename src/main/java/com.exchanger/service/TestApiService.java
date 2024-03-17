package com.exchanger.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class TestApiService {

    private final RestTemplate restTemplate;

    public String getAllUser() {
        String getListUsers = "https://reqres.in/api/users?page=2";
        return restTemplate.getForObject(getListUsers, String.class);
    }

    public ResponseEntity<String> addUser() {
        String addUser = "https://reqres.in/api/users";
        return restTemplate.postForEntity(addUser, String.class, String.class);
    }
}
