package com.sofka.microservice2.routes;

import com.sofka.microservice2.model.Currency;
import com.sofka.microservice2.port.CurrencyExchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class suscriptorMQ extends RouteBuilder {

    @Autowired
    @Qualifier("co")
    CurrencyExchange currencyExchange;

    @Override
    public void configure() throws Exception {
        from("activemq:my-activemq-queue")
                .log("Antes: ${body}")
                .unmarshal().json(JsonLibrary.Jackson, Currency.class)
                .bean(currencyExchange)
                .log("Despues: ${body}")
                .to("log:received-message-from-active-mq");
    }
}
