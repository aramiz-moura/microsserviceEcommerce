package com.letscode.produtosapi.repository;

import com.letscode.produtosapi.domain.ProdutoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProdutoRepository extends MongoRepository<ProdutoEntity, String> {
}
