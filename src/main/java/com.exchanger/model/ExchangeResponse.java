package com.exchanger.model;


// все данные будут конвертироваться в JSON и обратно автоматически
public record ExchangeResponse(
        Boolean success,
        Double result

) {
}

