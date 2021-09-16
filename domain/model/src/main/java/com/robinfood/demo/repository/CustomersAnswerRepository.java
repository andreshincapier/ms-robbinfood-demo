package com.robinfood.demo.repository;

import com.robinfood.demo.entity.CustomerAnswers;
import reactor.core.publisher.Mono;

public interface CustomersAnswerRepository {
    Mono<CustomerAnswers> save(CustomerAnswers customerAnswers);
}
