package com.sofka.microservice2;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Currency {
    private long id;
    private String from;
    private String to;
    private BigDecimal exchange;

    public Currency() {
    }

    public Currency(long id, String from, String to, BigDecimal exchange) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.exchange = exchange;
    }
}
