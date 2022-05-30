package com.letscode.vendasapi.handler;


import com.letscode.vendasapi.domain.VendaEntity;
import com.letscode.vendasapi.repository.VendaRepository;
import com.letscode.vendasapi.service.VendaService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class VendaHandler {



    private final VendaService vendaService;
    private final VendaRepository vendaRepository;

    public VendaHandler(VendaService vendaService, VendaRepository vendaRepository) {
        this.vendaService = vendaService;
        this.vendaRepository = vendaRepository;
    }


    //TODO: tentar terminar essa parte. É mono ou flux?
    public Mono<ServerResponse> criaVenda (ServerRequest serverRequest){
        return serverRequest.bodyToMono(VendaEntity.class)
                .flatMap(vendaService)
    }
}
