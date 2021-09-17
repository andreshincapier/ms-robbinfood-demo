package com.survey.demo.web;

import com.survey.demo.command.CustomerAnswersCommandUseCase;
import com.survey.demo.dto.CommandResponseDTO;
import com.survey.demo.dto.UserAnswersDTO;
import com.survey.demo.dto.UserSurveyAnswersDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static reactor.core.publisher.Mono.just;

@RunWith(SpringRunner.class)
@WebFluxTest(SurveyAnswersCommand.class)
public class SurveyAnswerCommandTest {

    @Autowired
    private WebTestClient testClient;

    @MockBean
    private CustomerAnswersCommandUseCase useCase;
    private final UserAnswersDTO userAnswersDTO = UserAnswersDTO.builder().questionId("5ef8e7a9451940acad6fc79c4a51e199").answer("V").build();
    private final UserSurveyAnswersDTO userSurveyAnswersDTO = UserSurveyAnswersDTO.builder().name("Kenyon").email("Lorenz4@yahoo.com").surveyId("43c0cfb10cca42f8b909308ce338c3c5").questionList(List.of(userAnswersDTO)).build();

    @Before
    public void init() {
        when(useCase.saveCustomersAnswers(userSurveyAnswersDTO))
                .then(i -> just(CommandResponseDTO.builder().message("Survey has send successful").build()));
    }

    @Test
    public void shouldSaveSurvey() {

        final WebTestClient.ResponseSpec spec = testClient.post().uri("/api/robin-food/survey/save-answers")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(userSurveyAnswersDTO)
                .exchange();

        spec.expectBody(CommandResponse.class).consumeWith(res -> {
            final HttpStatus status = res.getStatus();
            final CommandResponse body = res.getResponseBody();
            assertThat(status.is2xxSuccessful()).isTrue();
            assertThat(body)
                    .extracting(CommandResponse::getMessage)
                    .isEqualTo("Survey has send successful");
        });
    }

    @Data
    @NoArgsConstructor
    private static class CommandResponse {
        private String message;
    }

}