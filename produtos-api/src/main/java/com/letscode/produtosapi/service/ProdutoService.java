package com.letscode.produtosapi.service;


import com.letscode.produtosapi.domain.ProdutoEntity;
import com.letscode.produtosapi.domain.ProdutoRequest;
import com.letscode.produtosapi.domain.ProdutoResponse;
import com.letscode.produtosapi.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public ProdutoEntity toEntity(ProdutoRequest produtoRequest) {
        ProdutoEntity entity = new ProdutoEntity(
                produtoRequest.getNome(),
                produtoRequest.getDescricao(),
                produtoRequest.getPreco(),
                produtoRequest.getEstoque()
        );
        return produtoRepository.save(entity);
    }

    public ProdutoEntity getPorId(String idProduto) {
        return produtoRepository.findById(idProduto).orElseThrow();
    }
}
