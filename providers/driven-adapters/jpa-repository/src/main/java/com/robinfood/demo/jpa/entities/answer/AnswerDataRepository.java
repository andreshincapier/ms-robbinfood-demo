package com.robinfood.demo.jpa.entities.answer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;


public interface AnswerDataRepository extends CrudRepository<AnswerData, String>, QueryByExampleExecutor<AnswerData> {
}
