package com.survey.demo.repository;

import com.survey.demo.entity.Question;
import reactor.core.publisher.Flux;

public interface QuestionRepository {
    Flux<Question> findAllBySurveyId(String surveyId);
}
