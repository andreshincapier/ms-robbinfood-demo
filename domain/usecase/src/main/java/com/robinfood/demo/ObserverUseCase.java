package com.robinfood.demo;


import com.robinfood.demo.gateway.Configuration;
import com.robinfood.demo.gateway.ConfigurationRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ObserverUseCase {

    private final ConfigurationRepository configurationRepository;

    public Mono<Configuration> configuration() {
        return configurationRepository.findByTarget("1");
    }
}