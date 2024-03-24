package com.exchanger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ExchangerStarter {
    public static void main(String[] args) {
        SpringApplication.run(ExchangerStarter.class, args);
    }
}
