package com.letscode.produtosapi.controller;


import com.letscode.produtosapi.domain.ProdutoEntity;
import com.letscode.produtosapi.domain.ProdutoRequest;
import com.letscode.produtosapi.domain.ProdutoResponse;
import com.letscode.produtosapi.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("v1/produto")
public class ProdutoController {


    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("{idProduto}")
    public ResponseEntity<ProdutoResponse> getProduto(@PathVariable String idProduto) {


        ProdutoEntity entity = produtoService.getPorId(idProduto);
        ProdutoResponse response = new ProdutoResponse(entity);

        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> criaProduto(@RequestBody ProdutoRequest request) {
        return new ResponseEntity<>(new ProdutoResponse(produtoService.toEntity(request)),HttpStatus.CREATED);
    }

}
