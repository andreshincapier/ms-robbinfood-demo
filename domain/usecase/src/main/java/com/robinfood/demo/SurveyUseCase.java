package com.robinfood.demo;

import com.robinfood.demo.entity.Survey;
import com.robinfood.demo.repository.SurveyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
@RequiredArgsConstructor
public class SurveyUseCase {

    private final SurveyRepository surveyRepository;

    public Flux<Survey> listAllActiveSurvey() {
        log.info("ENTER IN SurveyUseCase :: listActiveSurveys");
        return surveyRepository.findAll()
                .doOnError(error -> log.error("ERROR IN SurveyUseCase :: listActiveSurveys {}", error.getMessage()));
    }
}
