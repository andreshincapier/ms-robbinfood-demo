package com.survey.demo.repository;

import com.survey.demo.entity.CustomerAnswers;
import reactor.core.publisher.Mono;

public interface CustomersAnswerRepository {
    Mono<CustomerAnswers> save(CustomerAnswers customerAnswers);
}
