package com.letscode.vendasapi.service;


import com.letscode.vendasapi.domain.VendaEntity;
import com.letscode.vendasapi.domain.VendaRequest;
import com.letscode.vendasapi.gateway.CarrinhoGateway;
import com.letscode.vendasapi.gateway.UsuarioGateway;
import com.letscode.vendasapi.repository.VendaRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VendaService {
    private final UsuarioGateway usuarioGateway;
    private final CarrinhoGateway carrinhoGateway;
    private final VendaRepository vendaRepository;

    public VendaService(UsuarioGateway usuarioGateway, CarrinhoGateway carrinhoGateway, VendaRepository vendaRepository) {
        this.usuarioGateway = usuarioGateway;
        this.carrinhoGateway = carrinhoGateway;
        this.vendaRepository = vendaRepository;
    }

    public Mono<VendaEntity> adicionaVenda(VendaRequest request){
        return Mono.zip(
                Mono.just(request).flatMap(venda -> usuarioGateway.getUsuario(venda.getUsuarioId())),
                Mono.just(request).flatMap(venda -> carrinhoGateway.getCarrinhoAtivo(venda.getUsuarioId()))
        ).map(tupla -> new VendaEntity(tupla.getT2()));
    }

    public Flux<VendaEntity> getVendaPorUsuario(VendaRequest vendaRequest){
        return Flux.just(vendaRequest.getUsuarioId()).flatMap(id -> vendaRepository.findAllByUsuarioId(id));
    }
}
