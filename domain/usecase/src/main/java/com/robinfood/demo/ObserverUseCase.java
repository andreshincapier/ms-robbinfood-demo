package com.robinfood.demo;


import com.robinfood.demo.gateway.Configuration;
import com.robinfood.demo.gateway.ConfigurationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
public class ObserverUseCase {

    private final ConfigurationRepository configurationRepository;

    public Mono<Configuration> configuration() {
        log.info("Enter to method configuration");
        return configurationRepository.findByTarget("1");
    }
}