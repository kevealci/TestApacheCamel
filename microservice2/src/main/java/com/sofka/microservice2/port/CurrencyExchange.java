package com.sofka.microservice2.port;

import com.sofka.microservice2.model.Currency;

public interface CurrencyExchange {
    public Currency processMessage(Currency currency);
}
