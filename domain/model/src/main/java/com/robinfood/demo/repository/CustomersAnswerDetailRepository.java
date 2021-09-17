package com.robinfood.demo.repository;

import com.robinfood.demo.entity.CustomerAnswersDetail;
import reactor.core.publisher.Mono;

public interface CustomersAnswerDetailRepository {
    Mono<CustomerAnswersDetail> save(CustomerAnswersDetail detail);
}
