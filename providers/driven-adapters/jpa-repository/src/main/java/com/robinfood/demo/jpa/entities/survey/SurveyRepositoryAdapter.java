package com.robinfood.demo.jpa.entities.survey;

import com.robinfood.demo.entity.Survey;
import com.robinfood.demo.reactive.repository.jpa.AdapterOperations;
import com.robinfood.demo.repository.SurveyRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.robinfood.demo.enums.StatusEnum.nameFromId;

@Repository
public class SurveyRepositoryAdapter extends AdapterOperations<Survey, SurveyData, String, SurveyDataRepository> implements SurveyRepository {

    @Autowired
    public SurveyRepositoryAdapter(SurveyDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, Survey.SurveyBuilder.class).build());
    }

    @Override
    public Mono<Survey> findByName(String var1) {
        return null;
    }

    @Override
    public Flux<Survey> findAll() {
        return doQueryMany(() -> repository.findAll())
                .doOnNext(dto -> dto.setStatus(nameFromId(dto.getStatus())));
    }

    @Override
    public Flux<Survey> findAllByStatus(String var1) {
        return null;
    }
}