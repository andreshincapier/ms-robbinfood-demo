package com.robinfood.demo;

import com.robinfood.demo.gateway.ConfigurationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.reactivecommons.utils.ObjectMapper;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class UseCaseConfigTest {

    @InjectMocks
    UseCaseConfig useCaseConfig;

    @Mock
    ConfigurationRepository repository;

//    @Test
//    public void objectMapperIsNotNull() {
//        ObjectMapper objectMapper = useCaseConfig.objectMapper();
//        assertThat(objectMapper).isNotNull();
//    }
//
//    @Test
//    public void saveMessage() {
//        ObserverUseCase messageUseCase = useCaseConfig.observerUseCase(repository);
//        assertThat(messageUseCase).isNotNull();
//    }

}