package com.exchanger.service;

import com.exchanger.model.ExchangeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class TestApiService {

    private final RestTemplate restTemplate;
    @Value("${exchanger.baseUrl}")
    private String exchangerURL;
    @Value("${exchanger.apikey}")
    private String key;
    /**
     * {@link RestTemplate#getForObject(URI, Class)} не позволяет добавить хедеры в запрос, поэтому остаётся использовать только {@link RestTemplate#exchange(URI, HttpMethod, HttpEntity, Class)}
     * @return Тело ответа в виде сущности.
     */
    public ExchangeResponse convert(String to, String from, Double amount) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("apikey", key);
        HttpEntity<Void> requestEntity = new HttpEntity<>(httpHeaders);
        String url = String.format("%s/convert?to=%s&from=%s&amount=%s", exchangerURL, to, from, amount.toString());

        return restTemplate.exchange(url, HttpMethod.GET, requestEntity, ExchangeResponse.class).getBody();
    }
}
