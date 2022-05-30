package com.letscode.carrinhosapi.service;


import com.letscode.carrinhosapi.domain.CarrinhoEntity;
import com.letscode.carrinhosapi.domain.CarrinhoRequest;
import com.letscode.carrinhosapi.domain.CarrinhoResponse;
import com.letscode.carrinhosapi.domain.ItemPedido;
import com.letscode.carrinhosapi.gateway.ProdutoGateway;
import com.letscode.carrinhosapi.repository.CarrinhoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.List;


@Service
public class CarrinhoService {

    private final CarrinhoRepository carrinhoRepository;
    private final ProdutoGateway produtoGateway;

    public CarrinhoService(CarrinhoRepository carrinhoRepository, ProdutoGateway produtoGateway) {
        this.carrinhoRepository = carrinhoRepository;
        this.produtoGateway = produtoGateway;
    }

    public CarrinhoEntity toEntity(CarrinhoRequest request){
        return new CarrinhoEntity(request.getIdUsuario());
    }


    public List<CarrinhoResponse> getCarrinhosAtivos(String usuarioId) {
        List<CarrinhoEntity> carrinhos = carrinhoRepository.getActiveCart(usuarioId,true);
        return carrinhos.stream().map(CarrinhoResponse::new).toList();
    }

    public ResponseEntity<CarrinhoResponse> criaCarrinho(CarrinhoRequest request) {

        List<CarrinhoEntity> carrinhos = carrinhoRepository.getActiveCart(request.getIdUsuario(),true);
        if(!carrinhos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }

        CarrinhoEntity entity = toEntity(request);
        carrinhoRepository.save(entity);
        CarrinhoResponse response = new CarrinhoResponse(entity);
        return ResponseEntity.ok(response);
    }


    public CarrinhoResponse adicionaProdutoNoCarrinho(ItemPedido itemPedido){
        CarrinhoEntity entity = carrinhoRepository.getActiveCart(itemPedido.getUsuarioId().toString(),true).get(0);
        if(entity.getListaProdutos().size() == 0 ) {
//            CarrinhoRequest request = new CarrinhoRequest(itemPedido.getProdutoId());
//            CarrinhoEntity carrinhoEntity = new CarrinhoEntity(request.getIdUsuario());
            entity.getListaProdutos().put(itemPedido.getProdutoId(),itemPedido.getQuantidade());
            CarrinhoResponse carrinhoResponse = new CarrinhoResponse(carrinhoRepository.save(entity));
            return carrinhoResponse;
        }

        entity.getListaProdutos().merge(itemPedido.getProdutoId(),itemPedido.getQuantidade(),(quantidade, novaQuantidade) -> (quantidade + novaQuantidade));
        BigDecimal precoFinal = entity.getListaProdutos().entrySet().stream().map(
                produto -> (produtoGateway.getPreco(produto.getKey()).getBody().multiply(BigDecimal.valueOf(produto.getValue())))
        ).reduce(BigDecimal.ZERO,BigDecimal::add);
        entity.setPrecoFinal(precoFinal);

        CarrinhoEntity entityNova = carrinhoRepository.save(entity);
        return new CarrinhoResponse(entityNova);
    }
}
