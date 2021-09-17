package com.survey.demo.handler;

import com.survey.demo.dto.SurveyQuestionDTO;
import com.survey.demo.entity.Survey;
import com.survey.demo.repository.QuestionRepository;
import com.survey.demo.repository.SurveyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;

@Slf4j
@RequiredArgsConstructor
public class SurveyHandlerUseCase {

    private final SurveyRepository surveyRepository;
    private final QuestionRepository questionRepository;

    public Flux<Survey> listAllActiveSurvey() {
        log.info("ENTER IN SurveyUseCase :: listActiveSurveys");
        return surveyRepository.findAll()
                .doOnError(error -> log.error("ERROR IN SurveyUseCase :: listActiveSurveys {}", error.getMessage()));
    }

    public Mono<SurveyQuestionDTO> findAllQuestionsBySurveyId(String surveyId) {
        log.info("ENTER IN SurveyUseCase :: listAllQuestionsBySurveyId WITH {}", surveyId);
        return Mono.justOrEmpty(surveyId)
                .flatMap(s -> surveyRepository.findById(surveyId)
                        .map(survey -> SurveyQuestionDTO.builder()
                                .id(survey.getId())
                                .name(survey.getName())
                                .build()
                        )
                        .switchIfEmpty(Mono.defer(() -> Mono.just(SurveyQuestionDTO.builder().build())))
                )
                .flatMap(surveyQuestion -> questionRepository.findAllBySurveyId(surveyId)
                        .collectList()
                        .map(questionList -> surveyQuestion.toBuilder()
                                .questionList(questionList)
                                .build()
                        )
                        .switchIfEmpty(Mono.defer(() -> Mono.just(surveyQuestion.toBuilder()
                                .questionList(Collections.emptyList())
                                .build()))
                        )
                )
                .doOnError(error -> log.error("ERROR IN SurveyUseCase :: listAllQuestionsBySurveyId {}", error.getMessage()));
    }


}
