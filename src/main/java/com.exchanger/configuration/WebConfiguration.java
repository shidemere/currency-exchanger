package com.exchanger.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@ConfigurationProperties("exchanger.freecurrencyapi")
@Getter
@Setter
public class WebConfiguration {

    private String baseUrl;
    private String apikey;
    @Bean
    public WebClient webClient(){
        return WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader("apikey", apikey)
                .build();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
