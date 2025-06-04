package org.example;

import io.javalin.Javalin;
import io.javalin.http.Header;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.bundledPlugins.enableCors(cors -> {
                cors.addRule(corsRule -> {
                    corsRule.anyHost();
                    corsRule.exposeHeader(Header.AUTHORIZATION);
                });
            });
        }).start(8080);
        
        app.get("/id", context -> context.result(UUID.randomUUID().toString()));
    }
}
