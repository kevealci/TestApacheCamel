package com.sofka.microservice2.adapter;

import com.sofka.microservice2.model.Currency;
import com.sofka.microservice2.port.CurrencyExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Qualifier("co")
public class CurrencyExchangeCol implements CurrencyExchange {
    @Override
    public Currency processMessage(Currency currency) {
        currency.setExchange(currency.getExchange().multiply(BigDecimal.TEN));
        return currency;
    }
}

