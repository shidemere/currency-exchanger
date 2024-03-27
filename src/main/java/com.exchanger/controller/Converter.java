package com.exchanger.controller;

import com.exchanger.model.ExchangeRequest;
import com.exchanger.model.ResponseDTO;
import com.exchanger.service.TestApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class Converter {

    private final TestApiService testApiService;

    @PostMapping("/latest")
    public String latest() {
        return testApiService.latest().toString();
    }

    @PostMapping("/rub")
    public Mono<ResponseDTO> listCurrenciesOfRub() {
        return testApiService.currenciesToRub();

    }

    @PostMapping("/convert")
    public String convert(@RequestBody ExchangeRequest exchangeRequest) {
        return testApiService.convert(exchangeRequest.getTo(), exchangeRequest.getFrom(), exchangeRequest.getAmount()).toString();
    }
}
