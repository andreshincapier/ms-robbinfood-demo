package com.robinfood.demo.repository;

import com.robinfood.demo.entity.Customers;
import reactor.core.publisher.Mono;

public interface CustomersRepository {
    Mono<Customers> save(Customers customers);
}
