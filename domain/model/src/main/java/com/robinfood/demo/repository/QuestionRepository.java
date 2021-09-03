package com.robinfood.demo.repository;

import com.robinfood.demo.entity.Question;
import reactor.core.publisher.Flux;

public interface QuestionRepository extends PersistenceDataRepository<Question, Question> {
    Flux<Question> findAllBySurveyId(String surveyId);
}
