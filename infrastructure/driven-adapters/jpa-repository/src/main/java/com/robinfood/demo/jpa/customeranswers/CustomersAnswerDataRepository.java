package com.robinfood.demo.jpa.customeranswers;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;


public interface CustomersAnswerDataRepository extends CrudRepository<CustomersAnswerData, String>, QueryByExampleExecutor<CustomersAnswerData> {
}
