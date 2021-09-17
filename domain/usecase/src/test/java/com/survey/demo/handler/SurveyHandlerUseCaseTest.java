package com.survey.demo.handler;

import com.survey.demo.dto.SurveyQuestionDTO;
import com.survey.demo.entity.Question;
import com.survey.demo.entity.Survey;
import com.survey.demo.repository.QuestionRepository;
import com.survey.demo.repository.SurveyRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static java.util.List.of;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static reactor.core.publisher.Flux.fromIterable;


@RunWith(MockitoJUnitRunner.class)
public class SurveyHandlerUseCaseTest {

    @InjectMocks
    private SurveyHandlerUseCase useCase;

    @Mock
    private SurveyRepository surveyRepository;

    @Mock
    private QuestionRepository questionRepository;

    @Before
    public void init() {
        when(surveyRepository.findAll()).thenReturn(fromIterable(List.of(survey)));
        when(surveyRepository.findById(any())).thenReturn(Mono.just(survey));
        when(questionRepository.findAllBySurveyId(any())).thenReturn(fromIterable(List.of(question)));
    }

    @Test
    public void shouldCreateGetHeaderByDate() {
        StepVerifier.create(useCase.listAllActiveSurvey())
                .expectNext(survey)
                .verifyComplete();
    }

    @Test
    public void shouldFindAllQuestionsBySurveyId() {
        StepVerifier.create(useCase.findAllQuestionsBySurveyId("something"))
                .expectNext(surveyQuestionDTO)
                .verifyComplete();
    }

    private final Survey survey = Survey
            .builder()
            .id("one")
            .name("two")
            .description("description")
            .status("ACTIVE")
            .build();

    private final Question question = Question
            .builder()
            .id("123")
            .content("two")
            .surveyId("two")
            .status("ACTIVE")
            .build();

    private final SurveyQuestionDTO surveyQuestionDTO = SurveyQuestionDTO
            .builder()
            .id("one")
            .name("two")
            .questionList(of(question))
            .build();
}