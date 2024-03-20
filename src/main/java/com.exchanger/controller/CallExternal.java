package com.exchanger.controller;

import com.exchanger.model.EchangeRequest;
import com.exchanger.service.TestApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CallExternal {

    private final TestApiService testApiService;

    @PostMapping()
    public String convert(@RequestBody EchangeRequest echangeRequest){
        return testApiService.convert(echangeRequest.to(), echangeRequest.from(), echangeRequest.amount()).toString();
    }


}
