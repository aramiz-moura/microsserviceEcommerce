package com.letscode.vendasapi.config;


import com.letscode.vendasapi.handler.VendaHandler;
import com.mongodb.internal.connection.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {


    @Bean
    public RouterFunction<ServerResponse> rota(VendaHandler vendaHandler) {
        return RouterFunctions.route()
                .POST()
    }
}
