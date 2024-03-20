package com.exchanger.model;

public record EchangeRequest(
        String from,
        String to,
        Double amount
) {
}
