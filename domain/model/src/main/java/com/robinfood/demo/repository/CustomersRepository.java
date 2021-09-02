package com.robinfood.demo.repository;

import com.robinfood.demo.entity.Customers;
import reactor.core.publisher.Mono;

public interface CustomersRepository extends PersistenceDataRepository<Customers, Customers> {

    Mono<Customers> findById(String var1);
}
