package com.letscode.carrinhosapi.repository;

import com.letscode.carrinhosapi.domain.CarrinhoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CarrinhoRepository extends MongoRepository<CarrinhoEntity, String> {
    @Query("{usuarioId: ?0, status: ?1}")
    List<CarrinhoEntity> getActiveCart(String usuarioId, Boolean status);
}
