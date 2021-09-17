package com.survey.demo.repository;

import com.survey.demo.entity.CustomerAnswersDetail;
import reactor.core.publisher.Mono;

public interface CustomersAnswerDetailRepository {
    Mono<CustomerAnswersDetail> save(CustomerAnswersDetail detail);
}
