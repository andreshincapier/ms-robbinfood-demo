package com.survey.demo.adapter.rest.testdata;

import com.survey.demo.adapter.rest.AbstractRestImpl;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class DataRestService extends AbstractRestImpl<DataDTO, DataEntity> implements DataService {

    public DataRestService(ModelMapper mapper) {
        super(mapper, DataDTO.class, DataEntity.class);
    }
}