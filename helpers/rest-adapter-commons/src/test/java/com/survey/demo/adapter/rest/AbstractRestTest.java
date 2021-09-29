package com.survey.demo.adapter.rest;

import com.survey.demo.adapter.rest.testdata.DataDTO;
import com.survey.demo.adapter.rest.testdata.DataEntity;
import com.survey.demo.adapter.rest.testdata.DataRestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AbstractRestTest {

    private final DataEntity dataEntity = new DataEntity();
    private final DataDTO dataDTO = new DataDTO();

    @Autowired
    private DataRestService service;

    @Test
    public void shouldMapToData() {
        Mono<DataEntity> dataEntityMono = Mono.just(service.mapToEntity(dataDTO));
        StepVerifier.create(dataEntityMono).expectNext(dataEntity).verifyComplete();
    }

    @Test
    public void shouldMapToEntity() {
        Mono<DataDTO> dataEntityMono = Mono.just(service.mapToDto(dataEntity));
        StepVerifier.create(dataEntityMono).expectNext(dataDTO).verifyComplete();
    }
}
