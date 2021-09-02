package com.robinfood.demo;


import com.robinfood.demo.gateway.Configuration;
import com.robinfood.demo.gateway.ConfigurationRepository;
import com.robinfood.demo.repository.mongo.CustomersRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ObserverUseCase {

    private final ConfigurationRepository configurationRepository;
    private final CustomersRepository customersRepository;

    public Mono<Configuration> configuration() {
        return configurationRepository.findByTarget("1")
                .flatMap(configuration -> customersRepository.findById("123")
                        .map(customers -> configuration.toBuilder()
                                .name(customers.getName())
                                .phone(customers.getPhone())
                                .build()
                        )
                );
    }
}