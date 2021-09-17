package com.survey.demo.postgres.survey;

import com.survey.demo.entity.Survey;
import com.survey.demo.reactive.repository.jpa.AdapterOperations;
import com.survey.demo.repository.SurveyRepository;
import com.survey.demo.enums.StatusEnum;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public class SurveyRepositoryAdapter extends AdapterOperations<Survey, SurveyData, String, SurveyDataRepository> implements SurveyRepository {

    @Autowired
    public SurveyRepositoryAdapter(SurveyDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, Survey.SurveyBuilder.class).build());
    }

    @Override
    public Flux<Survey> findAll() {
        return doQueryMany(() -> repository.findAll())
                .doOnNext(dto -> dto.setStatus(StatusEnum.nameFromId(dto.getStatus())));
    }
}