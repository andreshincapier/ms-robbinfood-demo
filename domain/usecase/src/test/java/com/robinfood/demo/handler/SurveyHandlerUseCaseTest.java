package com.robinfood.demo.handler;

import com.robinfood.demo.entity.Survey;
import com.robinfood.demo.repository.SurveyRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.List;

import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class SurveyHandlerUseCaseTest {

    @InjectMocks
    private SurveyHandlerUseCase useCase;

    @Mock
    private SurveyRepository surveyRepository;

    @Before
    public void init() {
        Flux<Survey> list = Flux.fromIterable(List.of(survey));
        when(surveyRepository.findAll()).thenReturn(list);
    }

    @Test
    public void shouldCreateGetHeaderByDate() {
        StepVerifier.create(useCase.listAllActiveSurvey())
                .expectNext(survey)
                .verifyComplete();
    }

    private final Survey survey = Survey
            .builder()
            .id("one")
            .name("two")
            .description("two")
            .status("10044848L")
            .build();

}