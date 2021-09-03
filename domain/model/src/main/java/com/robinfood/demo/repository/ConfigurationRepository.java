package com.robinfood.demo.repository;

import com.robinfood.demo.entity.Configuration;
import reactor.core.publisher.Mono;

public interface ConfigurationRepository {
    Mono<Configuration> findByTarget(String id);
}
