package com.letscode.vendasapi.gateway;


import com.letscode.vendasapi.domain.VendaComCarrinhoRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Component
public class CarrinhoGateway {

    public Mono<VendaComCarrinhoRequest> getCarrinhoAtivo(Integer usuarioId) {
        return WebClient
                .builder()
                .baseUrl(String.format("http://carrinhosAPI:8082/v1/carrinho/%s", usuarioId))
                .build()
                .get()
                .retrieve()
                .bodyToMono(VendaComCarrinhoRequest.class)
                .log()
                .onErrorResume(WebClientResponseException.class, error -> error.getRawStatusCode() == 404 ? Mono.empty() : Mono.error(error));
    }
}
