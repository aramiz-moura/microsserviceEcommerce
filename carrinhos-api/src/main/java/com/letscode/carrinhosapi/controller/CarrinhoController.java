package com.letscode.carrinhosapi.controller;


import com.letscode.carrinhosapi.domain.CarrinhoEntity;
import com.letscode.carrinhosapi.domain.CarrinhoResponse;
import com.letscode.carrinhosapi.domain.ItemPedido;
import com.letscode.carrinhosapi.service.CarrinhoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/carrinho")
public class CarrinhoController {

    private final CarrinhoService carrinhoService;

    public CarrinhoController(CarrinhoService carrinhoService) {
        this.carrinhoService = carrinhoService;
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<List<CarrinhoResponse>> getCarrinhoPorId(@PathVariable String idUsuario) {
        return new ResponseEntity<>(carrinhoService.getCarrinhosAtivos(idUsuario), HttpStatus.ACCEPTED);
    }

    @PostMapping("/add")
    public ResponseEntity<CarrinhoEntity> adicionaProdutoNoCarrinho(@RequestBody ItemPedido itemPedido) {





    }
}
