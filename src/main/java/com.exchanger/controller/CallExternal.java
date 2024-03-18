package com.exchanger.controller;

import com.exchanger.service.TestApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class CallExternal {

    private final TestApiService testApiService;

    @PostMapping()
    public String convert(@RequestBody Map<String, String> json) {
        return String.valueOf(testApiService.convert(json.get("to"), json.get("from"), json.get("amount")));
    }


}
