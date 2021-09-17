package com.survey.demo.postgres.detailanswers;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;


public interface CustomersAnswerDetailDataRepository extends CrudRepository<CustomersAnswerDetailData, String>, QueryByExampleExecutor<CustomersAnswerDetailData> {
}
