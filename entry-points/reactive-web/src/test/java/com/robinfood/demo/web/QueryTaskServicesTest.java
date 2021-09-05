package com.robinfood.demo.web;

import com.robinfood.demo.entity.Configuration;
import com.robinfood.demo.handler.ObserverHandlerUseCase;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebFluxTest(TestQueryHandler.class)
public class QueryTaskServicesTest {

    @Autowired
    private WebTestClient testClient;

    @MockBean
    private ObserverHandlerUseCase useCase;
    private final Configuration configuration = Configuration.builder().name("Daniel").id("03").phone(123L).build();


    @Before
    public void init() {
        final Mono<Configuration> tasks = Mono.just(configuration);
        when(useCase.configuration()).thenReturn(tasks);
    }


    @Test
    public void shouldFindWithDetails() {

        final WebTestClient.ResponseSpec spec = testClient.get().uri("/api/ms-test/api/test/test")
                .exchange();

        spec.expectBody(UserDTO.class)
                .consumeWith(res -> {
                            final HttpStatus status = res.getStatus();
                            final UserDTO body = res.getResponseBody();
                            assertThat(status.is2xxSuccessful()).isTrue();
                            assertThat(body.getId()).isEqualTo("03");
                            assertThat(body.getName()).isEqualTo("Daniel");
                        }
                );
    }


    @Data
    @NoArgsConstructor
    private static class UserDTO {
        private String id;
        private String name;
        private String lastName;
    }

}