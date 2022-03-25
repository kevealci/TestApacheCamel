package com.sofka.microservice2.routes;

import com.sofka.microservice2.Currency;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.sofka.microservice2.CurrencyExchangeTransformations;

@Component
public class suscriptorMQ extends RouteBuilder {

    @Autowired
    CurrencyExchangeTransformations currencyExchangeTransformations;

    @Override
    public void configure() throws Exception {
        from("activemq:my-activemq-queue")
                .log("${body}")
                .unmarshal().json(JsonLibrary.Jackson, Currency.class)
                .bean(currencyExchangeTransformations)
                .to("log:received-message-from-active-mq");
    }
}
