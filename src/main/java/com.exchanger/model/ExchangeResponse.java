package com.exchanger.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ExchangeResponse {
    Boolean success;
    Double result;
}
