package com.exchanger.controller;

import com.exchanger.model.EchangeRequest;
import com.exchanger.service.TestApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Converter {

    private final TestApiService testApiService;

    @PostMapping("/latest")
    public String latest() {
        return testApiService.latest().toString();
    }

    @PostMapping("/rub")
    public String listCurrenciesOfRub() {
        return testApiService.currenciesToRub().toString();

    }

    @PostMapping("/convert")
    public String convert(@RequestBody EchangeRequest echangeRequest) {
        return testApiService.convert(echangeRequest.getTo(), echangeRequest.getFrom(), echangeRequest.getAmount()).toString();
    }
}
