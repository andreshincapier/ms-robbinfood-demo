package com.survey.demo.web;

import com.survey.demo.dto.SurveyQuestionDTO;
import com.survey.demo.entity.Question;
import com.survey.demo.entity.Survey;
import com.survey.demo.handler.SurveyHandlerUseCase;
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
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebFluxTest(SurveyQueryHandler.class)
public class SurveyQueryHandlerTest {

    @Autowired
    private WebTestClient testClient;

    @MockBean
    private SurveyHandlerUseCase useCase;
    private final Survey survey1 = Survey.builder().id("123").name("survey1").description("description1").status("ACTIVE").build();
    private final Survey survey2 = Survey.builder().id("456").name("survey2").description("description2").status("ACTIVE").build();
    private final SurveyQuestionDTO surveyQuestionDTO = SurveyQuestionDTO.builder().id("123").name("Question").description("description").status("ACTIVE").build();

    @Before
    public void init() {
        final Flux<Survey> surveys = Flux.just(survey1, survey2);
        when(useCase.listAllActiveSurvey()).thenReturn(surveys);

        final Mono<SurveyQuestionDTO> surveyMono = Mono.just(surveyQuestionDTO);
        when(useCase.findAllQuestionsBySurveyId("123")).thenReturn(surveyMono);
    }

    @Test
    public void shouldListSurvey() {

        final WebTestClient.ResponseSpec spec = testClient.get().uri("/api/robin-food/survey/list-all-active")
                .exchange();

        spec.expectBodyList(SurveyDTO.class).consumeWith(res -> {
            final HttpStatus status = res.getStatus();
            final List<SurveyDTO> body = res.getResponseBody();
            assertThat(status.is2xxSuccessful()).isTrue();
            assertThat(body).hasSize(2).extracting(SurveyDTO::getName)
                    .containsExactly("survey1", "survey2");
        });
    }

    @Test
    public void shouldListAllDetailSuccess() {
        final WebTestClient.ResponseSpec spec = testClient
                .get()
                .uri("/api/robin-food/survey/list-questions-by-survey/123")
                .exchange();

        spec.expectBody(SurveyQuestion.class).consumeWith(consumer -> {
            final HttpStatus status = consumer.getStatus();
            final SurveyQuestion body = consumer.getResponseBody();
            assertThat(status.is2xxSuccessful()).isTrue();
            assertThat(body).isNotNull();
            assertThat(body.getId()).isEqualTo("123");
            assertThat(body.getName()).isEqualTo("Question");
        });
    }


    @Data
    @NoArgsConstructor
    private static class SurveyDTO {
        private String id;
        private String name;
        private String lastName;
        private String status;
    }

    @Data
    @NoArgsConstructor
    private static class SurveyQuestion {
        private String id;
        private String name;
        private String description;
        private String status;
        private List<Question> questionList;
    }

}