package com.survey.demo.repository;

import com.survey.demo.entity.Question;
import reactor.core.publisher.Flux;

public interface QuestionRepository extends PersistenceDataRepository<Question, Question> {
    Flux<Question> findAllBySurveyId(String surveyId);
}
