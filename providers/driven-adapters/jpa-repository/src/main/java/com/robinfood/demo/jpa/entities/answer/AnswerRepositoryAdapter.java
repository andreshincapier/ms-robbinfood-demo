package com.robinfood.demo.jpa.entities.answer;

import com.robinfood.demo.entity.Answer;
import com.robinfood.demo.reactive.repository.jpa.AdapterOperations;
import com.robinfood.demo.repository.AnswerRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class AnswerRepositoryAdapter extends AdapterOperations<Answer, AnswerData, String, AnswerDataRepository> implements AnswerRepository {


    @Autowired
    public AnswerRepositoryAdapter(AnswerDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, Answer.AnswerBuilder.class).build());
    }


    @Override
    public Mono<Answer> findByName(String var1) {
        return null;
    }

    @Override
    public Flux<Answer> findAll() {
        return null;
    }

    @Override
    public Flux<Answer> findAllByStatus(String var1) {
        return null;
    }
}
