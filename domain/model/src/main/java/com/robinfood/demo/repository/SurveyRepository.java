package com.robinfood.demo.repository;

import com.robinfood.demo.entity.Survey;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SurveyRepository {
    Flux<Survey> findAll();
    Mono<Survey> findById(String surveyId);
}
