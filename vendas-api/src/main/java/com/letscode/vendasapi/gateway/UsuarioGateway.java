package com.letscode.vendasapi.gateway;


import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Component
public class UsuarioGateway {

    public Mono<String> getUsuario(Integer usuarioId) {
        return WebClient
                .builder()
                .baseUrl(String.format("htttp://usuariosAPI:8080/v1/usuario/%s", usuarioId))
                .build()
                .get()
                .retrieve()
                .bodyToMono(String.class)
                .onErrorResume(WebClientResponseException.class,error -> error.getRawStatusCode() == 404 ? Mono.empty() : Mono.error(error));
    }
}
