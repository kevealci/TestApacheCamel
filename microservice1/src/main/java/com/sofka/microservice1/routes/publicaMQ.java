package com.sofka.microservice1.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class publicaMQ extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:files/json")
                .log("start ${body}")
                .to("activemq:my-activemq-queue");
    }
}
