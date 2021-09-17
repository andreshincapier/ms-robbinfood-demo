package com.survey.demo.repository;

import com.survey.demo.entity.Customers;
import reactor.core.publisher.Mono;

public interface CustomersRepository {
    Mono<Customers> save(Customers customers);
}
