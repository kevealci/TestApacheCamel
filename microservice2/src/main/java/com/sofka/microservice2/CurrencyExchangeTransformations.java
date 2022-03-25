package com.sofka.microservice2;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CurrencyExchangeTransformations {

    public Currency processMessage(Currency currency) {
        currency.setExchange(currency.getExchange().multiply(BigDecimal.TEN));
        return currency;
    }
}

