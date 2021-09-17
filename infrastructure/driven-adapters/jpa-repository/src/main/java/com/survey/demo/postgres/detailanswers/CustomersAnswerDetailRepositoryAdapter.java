package com.survey.demo.postgres.detailanswers;

import com.survey.demo.entity.CustomerAnswersDetail;
import com.survey.demo.reactive.repository.jpa.AdapterOperations;
import com.survey.demo.repository.CustomersAnswerDetailRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomersAnswerDetailRepositoryAdapter extends AdapterOperations<CustomerAnswersDetail, CustomersAnswerDetailData, String, CustomersAnswerDetailDataRepository> implements CustomersAnswerDetailRepository {

    @Autowired
    public CustomersAnswerDetailRepositoryAdapter(CustomersAnswerDetailDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, CustomerAnswersDetail.CustomerAnswersDetailBuilder.class).build());
    }
}