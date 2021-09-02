package com.robinfood.demo;

import com.robinfood.demo.gateway.Configuration;
import com.robinfood.demo.gateway.ConfigurationRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class ObserverUseCaseTest {

    @InjectMocks
    private ObserverUseCase useCase;

    @Mock
    private ConfigurationRepository configurationRepository;

    @Before
    public void init() {
        final Mono<Configuration> someTest = Mono.just(configuration);

        when(configurationRepository.findByTarget("1")).thenReturn(someTest);
    }

    @Test
    public void shouldCreateGetHeaderByDate() {
        StepVerifier.create(useCase.configuration())
                .expectNext(configuration)
                .verifyComplete();
    }

    private final Configuration configuration = Configuration
            .builder()
            .id("one")
            .name("two")
            .phone(10044848L)
            .build();

}