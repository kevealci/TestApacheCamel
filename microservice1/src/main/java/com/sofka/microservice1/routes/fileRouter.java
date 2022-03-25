package com.sofka.microservice1.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class fileRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:files/start_json")
                .log("start ${body}")
                .to("file:files/end_json");
    }
}
