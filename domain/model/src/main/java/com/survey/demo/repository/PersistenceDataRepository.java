package com.survey.demo.repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersistenceDataRepository<I, O> {
    Mono<I> findByName(String var1);

    Flux<O> findAll();

    Mono<I> findById(String var1);

    Flux<O> findAllByStatus(String var1);

    Mono<O> save(I var1);
}
