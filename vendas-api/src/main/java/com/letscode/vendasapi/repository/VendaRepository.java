package com.letscode.vendasapi.repository;

import com.letscode.vendasapi.domain.VendaEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface VendaRepository extends ReactiveMongoRepository<VendaEntity, String> {

    Flux<VendaEntity> findAllByUsuarioId(Integer id);
}
