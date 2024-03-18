package com.exchanger.service;

import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TestApiService {

    private final RestTemplate restTemplate;

    public BigDecimal convert(String to, String from, String amount) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("apikey", "RKsaWSZclALRFkaexdR9JApHMIltniMu");
        HttpEntity<Void> requestEntity = new HttpEntity<>(httpHeaders);
        String url = String.format("https://api.apilayer.com/fixer/convert?to=%s&from=%s&amount=%s", to, from, amount);
        ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
        JSONObject jsonObject = new JSONObject(exchange.getBody());
        return (BigDecimal) jsonObject.get("result");
    }
}
