package com.robinfood.demo.jpa.entities.configuration;

import com.robinfood.demo.entity.Configuration;
import com.robinfood.demo.repository.ConfigurationRepository;
import com.robinfood.demo.reactive.repository.jpa.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class ConfigurationRepositoryAdapter extends AdapterOperations<Configuration, ConfigurationData, String, ConfigurationDataRepository> implements ConfigurationRepository {


    @Autowired
    public ConfigurationRepositoryAdapter(ConfigurationDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, Configuration.ConfigurationBuilder.class).build());
    }

    @Override
    public Mono<Configuration> findByTarget(String id) {
        return Mono.fromSupplier(() -> repository.findAllById(id))
                .flatMap(Mono::just)
                .map(this::toEntity);
    }
}
