package com.robinfood.demo.gateway;

import reactor.core.publisher.Mono;

public interface ConfigurationRepository {
    Mono<Configuration> findByTarget(String id);
}
