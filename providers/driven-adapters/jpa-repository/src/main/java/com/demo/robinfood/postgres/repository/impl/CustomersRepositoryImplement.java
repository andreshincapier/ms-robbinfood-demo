package com.demo.robinfood.postgres.repository.impl;

import com.demo.robinfood.postgres.repository.entity.CustomersEntity;
import com.demo.robinfood.postgres.repository.jpa.JpaCustomersRepository;
import com.robinfood.demo.entity.Customers;
import com.robinfood.demo.reactive.repository.jpa.AdapterOperations;
import com.robinfood.demo.repository.mongo.CustomersRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class CustomersRepositoryImplement extends AdapterOperations<Customers, CustomersEntity, String, JpaCustomersRepository> implements CustomersRepository {

    @Autowired
    public CustomersRepositoryImplement(JpaCustomersRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, Customers.CustomersBuilder.class).build());
    }

    @Override
    public Mono<Customers> findByName(String var1) {
        return null;
    }

    @Override
    public Flux<Customers> findAll() {
        return null;
    }

    @Override
    public Flux<Customers> findAllByStatus(String var1) {
        return null;
    }

//    @Override
//    public Mono<Customers> findByName(String name) {
//        return null;
//    }
//
//    @Override
//    public Flux<Customers> findAll() {
//        return doQueryMany(() -> repository.findAll());
//    }
//
//    @Override
//    public Mono<Customers> findById(String customersId) {
//        return Mono.justOrEmpty(repository.findById(customersId))
//                .map(this::toEntity);
//    }
//
//    @Override
//    public Flux<Customers> findAllByStatus(String status) {
//        return doQueryMany(() -> repository.findAllByStatus(status));
//    }
//
//    @Override
//    public Mono<Customers> save(Customers customer) {
//        return null;
//    }
}