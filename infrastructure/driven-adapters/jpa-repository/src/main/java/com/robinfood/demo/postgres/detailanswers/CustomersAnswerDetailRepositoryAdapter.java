package com.robinfood.demo.postgres.detailanswers;

import com.robinfood.demo.entity.CustomerAnswersDetail;
import com.robinfood.demo.reactive.repository.jpa.AdapterOperations;
import com.robinfood.demo.repository.CustomersAnswerDetailRepository;
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