package com.robinfood.demo;

import com.robinfood.demo.gateway.ConfigurationRepository;
import com.robinfood.demo.repository.mongo.CustomersRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.reactivecommons.utils.ObjectMapperImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapperImp();
    }

    @Bean
    public ObserverUseCase observerUseCase(ConfigurationRepository configurationRepository, CustomersRepository customersRepository) {
        return new ObserverUseCase(configurationRepository, customersRepository);
    }
}
