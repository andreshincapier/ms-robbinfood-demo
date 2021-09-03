package com.robinfood.demo.jpa.entities.customeranswers;

import com.robinfood.demo.entity.CustomerAnswers;
import com.robinfood.demo.reactive.repository.jpa.AdapterOperations;
import com.robinfood.demo.repository.CustomersAnswerRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class CustomersAnswerRepositoryAdapter extends AdapterOperations<CustomerAnswers, CustomersAnswerData, String, CustomersAnswerDataRepository> implements CustomersAnswerRepository {

    @Autowired
    public CustomersAnswerRepositoryAdapter(CustomersAnswerDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, CustomerAnswers.CustomerAnswersBuilder.class).build());
    }

    @Override
    public Mono<CustomerAnswers> findByName(String var1) {
        return null;
    }

    @Override
    public Flux<CustomerAnswers> findAll() {
        return null;
    }

    @Override
    public Flux<CustomerAnswers> findAllByStatus(String var1) {
        return null;
    }
}