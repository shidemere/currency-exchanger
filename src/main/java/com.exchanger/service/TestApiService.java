package com.exchanger.service;

import com.exchanger.model.Currency;
import com.exchanger.model.ExchangeResponse;
import com.exchanger.model.ResponseDTO;
import com.exchanger.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TestApiService {

    private final WebClient webClient;
    private final CurrencyRepository repository;
    private final RestTemplate restTemplate;
    @Value("${exchanger.fixer.baseUrl}")
    private String exchangerURL;
    @Value("${exchanger.fixer.apikey}")
    private String key;

    public Currency latest() {
        ResponseDTO block = webClient
                .get()
                .uri("/latest")
                .retrieve()
                .bodyToMono(ResponseDTO.class)
                .block();
        Currency currency = new Currency();
        currency.setData(block.getData().toString());
        return currency;
    }

    @Scheduled(fixedDelayString = "${exchanger.delay}")
    public Currency currenciesToRub() {
        ResponseDTO responseDTO = webClient
                .get()
                .uri("/latest/?base_currency=RUB")
                .retrieve()
                .bodyToMono(ResponseDTO.class)
                .block();

        Currency currency = new Currency();
        currency.setData(responseDTO.getData().toString());
        currency.setTimeCreation(LocalDateTime.now());
        repository.save(currency);

        return currency;
    }

    public ExchangeResponse convert(String to, String from, Double amount) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("apikey", key);
        HttpEntity<Void> requestEntity = new HttpEntity<>(httpHeaders);
        String url = String.format("%s/convert?to=%s&from=%s&amount=%s", exchangerURL, to, from, amount.toString());

        return restTemplate.exchange(url, HttpMethod.GET, requestEntity, ExchangeResponse.class).getBody();
    }
}
