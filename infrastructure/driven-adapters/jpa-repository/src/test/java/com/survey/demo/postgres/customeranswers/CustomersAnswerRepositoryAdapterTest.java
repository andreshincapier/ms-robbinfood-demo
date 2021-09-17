package com.survey.demo.postgres.customeranswers;

import com.survey.demo.entity.CustomerAnswers;
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
public class CustomersAnswerRepositoryAdapterTest {

    private final CustomerAnswers customerAnswers = CustomerAnswers.builder().id("3123QWERTY").customerId("John").creationDate(3892389L).surveyId("algo@test.com").build();
    private final CustomerAnswers customerAnswers2 = CustomerAnswers.builder().id("3123QWERTY2").customerId("John 2").creationDate(3892389L).surveyId("algo2@test.com").build();

    @Autowired
    private CustomersAnswerRepositoryAdapter adapter;

    @Before
    public void saveInitialData() {
        final Mono<CustomerAnswers> result = adapter.save(customerAnswers).then(adapter.save(customerAnswers2));
        StepVerifier.create(result).assertNext(customers1 -> {
        }).verifyComplete();
    }

    @Test
    public void shouldSave() {
        final Mono<CustomerAnswers> result = adapter.save(customerAnswers);
        StepVerifier.create(result).assertNext(response -> {
        }).verifyComplete();
    }

    @Test
    public void shouldFindAll() {
        StepVerifier.create(adapter.findById("3123QWERTY"))
                .assertNext(tasks -> assertThat(customerAnswers))
                .verifyComplete();
    }

}