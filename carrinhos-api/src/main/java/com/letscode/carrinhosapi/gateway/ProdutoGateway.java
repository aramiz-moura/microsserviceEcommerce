package com.letscode.carrinhosapi.gateway;


import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class ProdutoGateway {

    private final RestTemplate restTemplate;

    public ProdutoGateway(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    //CRIAR NA HROA DE FAZER UM MAP, DE PRODUTO PARA ITEM PEDIDO
    public ResponseEntity<BigDecimal> getPreco(String idProduto) {
        String url = String.format("http://produtosAPI:8082/v1/produto/preco/%s", idProduto);
        return restTemplate.getForEntity(url,BigDecimal.class);
    }

}
