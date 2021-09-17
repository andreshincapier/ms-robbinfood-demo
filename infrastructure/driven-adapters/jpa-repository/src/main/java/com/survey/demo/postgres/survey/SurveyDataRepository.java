package com.survey.demo.postgres.survey;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;


public interface SurveyDataRepository extends CrudRepository<SurveyData, String>, QueryByExampleExecutor<SurveyData> {
}
