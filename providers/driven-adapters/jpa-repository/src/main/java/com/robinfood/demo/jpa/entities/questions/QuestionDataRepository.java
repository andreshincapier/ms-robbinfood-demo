package com.robinfood.demo.jpa.entities.questions;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;


public interface QuestionDataRepository extends CrudRepository<QuestionData, String>, QueryByExampleExecutor<QuestionData> {
}
