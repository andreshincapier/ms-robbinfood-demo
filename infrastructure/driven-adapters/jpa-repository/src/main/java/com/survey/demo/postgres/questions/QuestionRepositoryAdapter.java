package com.survey.demo.postgres.questions;

import com.survey.demo.entity.Question;
import com.survey.demo.reactive.repository.jpa.AdapterOperations;
import com.survey.demo.repository.QuestionRepository;
import com.survey.demo.enums.StatusEnum;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class QuestionRepositoryAdapter extends AdapterOperations<Question, QuestionData, String, QuestionDataRepository> implements QuestionRepository {

    @Autowired
    public QuestionRepositoryAdapter(QuestionDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, Question.QuestionBuilder.class).build());
    }

    @Override
    public Mono<Question> findByName(String var1) {
        return null;
    }

    @Override
    public Flux<Question> findAll() {
        return null;
    }

    @Override
    public Flux<Question> findAllByStatus(String var1) {
        return null;
    }

    @Override
    public Flux<Question> findAllBySurveyId(String surveyId) {
        return doQueryMany(() -> repository.findAllBySurveyId(surveyId))
                .doOnNext(dto -> dto.setStatus(StatusEnum.nameFromId(dto.getStatus())));
    }
}