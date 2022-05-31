package com.letscode.vendasapi.handler;


import com.letscode.vendasapi.domain.VendaEntity;
import com.letscode.vendasapi.domain.VendaRequest;
import com.letscode.vendasapi.repository.VendaRepository;
import com.letscode.vendasapi.service.VendaService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
public class VendaHandler {



    private final VendaService vendaService;
    private final VendaRepository vendaRepository;

    public VendaHandler(VendaService vendaService, VendaRepository vendaRepository) {
        this.vendaService = vendaService;
        this.vendaRepository = vendaRepository;
    }


    public Mono<ServerResponse> criaVenda (ServerRequest serverRequest){
        return serverRequest.bodyToMono(VendaRequest.class)
                .flatMap(vendaService::adicionaVenda)
                .flatMap(vendaRepository::save)
                .flatMap(vendaEntity -> ServerResponse
                        .created(URI.create(String.format("/venda/%s",vendaEntity.getId()))).bodyValue(new VendaEntity()))
                .switchIfEmpty(ServerResponse.unprocessableEntity().bodyValue("Usuario não existente"));
    }


    //flux para mono
    public Mono<ServerResponse> getVendaPorUsuario(ServerRequest request) {
        return request.bodyToFlux(VendaRequest.class)
                .flatMap(vendaService::getVendaPorUsuario)
                .collectList().flatMap(vendas -> ServerResponse
                        .ok().bodyValue(vendas))
                .switchIfEmpty(ServerResponse.unprocessableEntity().bodyValue("Usuario não existente"));
    }
}
