package com.sofka.microservice1.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class firstRoutes extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer:first-timer?period=10000")
                .log("${body}")
                .setBody(simple("Prueba1"))
                .to("direct:remoteService");

        from("direct:remoteService")
                .log("start remote service ${body}")
                .setBody(simple("Prueba2"))
                .to("log:remoteService");


    }
}
