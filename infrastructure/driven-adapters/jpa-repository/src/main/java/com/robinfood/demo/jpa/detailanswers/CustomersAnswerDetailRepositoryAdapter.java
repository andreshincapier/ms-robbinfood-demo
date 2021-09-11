package com.robinfood.demo.jpa.detailanswers;

import com.robinfood.demo.entity.CustomerAnswersDetail;
import com.robinfood.demo.reactive.repository.jpa.AdapterOperations;
import com.robinfood.demo.repository.CustomersAnswerDetailRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class CustomersAnswerDetailRepositoryAdapter extends AdapterOperations<CustomerAnswersDetail, CustomersAnswerDetailData, String, CustomersAnswerDetailDataRepository> implements CustomersAnswerDetailRepository {

    @Autowired
    public CustomersAnswerDetailRepositoryAdapter(CustomersAnswerDetailDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, CustomerAnswersDetail.CustomerAnswersDetailBuilder.class).build());
    }

    @Override
    public Mono<CustomerAnswersDetail> findByName(String var1) {
        return null;
    }

    @Override
    public Flux<CustomerAnswersDetail> findAll() {
        return null;
    }

    @Override
    public Flux<CustomerAnswersDetail> findAllByStatus(String var1) {
        return null;
    }
}