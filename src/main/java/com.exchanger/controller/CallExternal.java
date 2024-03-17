package com.exchanger.controller;

import com.exchanger.service.TestApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CallExternal {

    private final TestApiService testApiService;

    @GetMapping()
    public String hi() {
        return "Hello world!";
    }

    @GetMapping("/getListUsers")
    public String getAllUsers(){
        return testApiService.getAllUser();
    }


    @PostMapping("/add")
    public String addUser() {
        ResponseEntity<String> stringResponseEntity = testApiService.addUser();
        return stringResponseEntity.getBody();
    }
}
