package com.robinfood.demo.jpa.entities.customers;

import com.robinfood.demo.entity.Customers;
import com.robinfood.demo.reactive.repository.jpa.AdapterOperations;
import com.robinfood.demo.repository.CustomersRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class CustomersRepositoryAdapter extends AdapterOperations<Customers, CustomersData, String, CustomersDataRepository> implements CustomersRepository {

    @Autowired
    public CustomersRepositoryAdapter(CustomersDataRepository repository, ObjectMapper mapper) {
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

    @Override
    public Mono<Customers> findById(String customersId) {
        return Mono.justOrEmpty(repository.findById(customersId))
                .map(this::toEntity);
    }
}