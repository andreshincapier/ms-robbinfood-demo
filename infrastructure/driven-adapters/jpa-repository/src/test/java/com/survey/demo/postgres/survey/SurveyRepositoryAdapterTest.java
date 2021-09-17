package com.survey.demo.postgres.survey;

import com.survey.demo.entity.Survey;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SurveyRepositoryAdapterTest {

    private final Survey survey = Survey.builder().id("3123QWERTY").name("John").description("description").status("ACTIVE").build();
    private final Survey survey2 = Survey.builder().id("3123QWERTY").name("John").description("description").status("ACTIVE").build();

    @Autowired
    private SurveyRepositoryAdapter adapter;


    @Before
    public void saveInitialData() {
        final Mono<Survey> result = adapter.save(survey).then(adapter.save(survey2));
        StepVerifier.create(result).assertNext(customers1 -> {
        }).verifyComplete();
    }

    @Test
    public void shouldSave() {
        final Mono<Survey> result = adapter.save(survey);
        StepVerifier.create(result).assertNext(customers1 -> {
        }).verifyComplete();
    }

    @Test
    public void shouldFindAll() {
        StepVerifier.create(adapter.findById("3123QWERTY"))
                .assertNext(tasks -> assertThat(survey))
                .verifyComplete();
    }
}