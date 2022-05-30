package com.letscode.carrinhosapi.controller;


import com.letscode.carrinhosapi.domain.CarrinhoEntity;
import com.letscode.carrinhosapi.domain.CarrinhoRequest;
import com.letscode.carrinhosapi.domain.CarrinhoResponse;
import com.letscode.carrinhosapi.domain.ItemPedido;
import com.letscode.carrinhosapi.gateway.UsuarioGateway;
import com.letscode.carrinhosapi.service.CarrinhoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/carrinho")
public class CarrinhoController {

    private final CarrinhoService carrinhoService;
    private final UsuarioGateway usuarioGateway;

    public CarrinhoController(CarrinhoService carrinhoService, UsuarioGateway usuarioGateway) {
        this.carrinhoService = carrinhoService;
        this.usuarioGateway = usuarioGateway;
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<List<CarrinhoResponse>> getCarrinhoPorId(@PathVariable String idUsuario) {
        return new ResponseEntity<>(carrinhoService.getCarrinhosAtivos(idUsuario), HttpStatus.ACCEPTED);
    }

    @PostMapping("/add")
    public ResponseEntity<CarrinhoResponse> adicionaProdutoNoCarrinho(@RequestBody ItemPedido itemPedido) {
        ResponseEntity<String> usuarioResponse = usuarioGateway.getUsuario(itemPedido.getUsuarioId());
        if(!usuarioResponse.getStatusCode().equals(HttpStatus.OK)) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        List<CarrinhoResponse> carrinho = carrinhoService.getCarrinhosAtivos(itemPedido.getUsuarioId().toString());
        if(carrinho.size() == 0) {
            CarrinhoRequest request = new CarrinhoRequest(itemPedido.getUsuarioId().toString());
            carrinhoService.criaCarrinho(request);
        }
        CarrinhoResponse response = carrinhoService.adicionaProdutoNoCarrinho(itemPedido);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }
}
