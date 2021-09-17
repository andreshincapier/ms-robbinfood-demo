package com.survey.demo.postgres.customeranswers;

import com.survey.demo.entity.CustomerAnswers;
import com.survey.demo.reactive.repository.jpa.AdapterOperations;
import com.survey.demo.repository.CustomersAnswerRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomersAnswerRepositoryAdapter extends AdapterOperations<CustomerAnswers, CustomersAnswerData, String, CustomersAnswerDataRepository> implements CustomersAnswerRepository {

    @Autowired
    public CustomersAnswerRepositoryAdapter(CustomersAnswerDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, CustomerAnswers.CustomerAnswersBuilder.class).build());
    }
}