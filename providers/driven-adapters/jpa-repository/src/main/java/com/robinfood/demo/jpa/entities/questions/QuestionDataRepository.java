package com.robinfood.demo.jpa.entities.questions;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;


public interface QuestionDataRepository extends CrudRepository<QuestionData, String>, QueryByExampleExecutor<QuestionData> {
    List<QuestionData> findAllBySurveyId(String survey);
}
