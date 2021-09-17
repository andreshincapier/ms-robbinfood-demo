package com.survey.demo.postgres.detailanswers;

import com.survey.demo.entity.CustomerAnswersDetail;
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
public class CustomersAnswerDetailRepositoryAdapterTest {

    private final CustomerAnswersDetail detail = CustomerAnswersDetail.builder().id("3123QWERTY").customersAnswersId("John").questionId("3892389L").answer("algo@test.com").build();
    private final CustomerAnswersDetail detail2 = CustomerAnswersDetail.builder().id("3123QWERTY2").customersAnswersId("John 2").questionId("3892389L").answer("algo2@test.com").build();

    @Autowired
    private CustomersAnswerDetailRepositoryAdapter adapter;

    @Before
    public void saveInitialData() {
        final Mono<CustomerAnswersDetail> result = adapter.save(detail).then(adapter.save(detail2));
        StepVerifier.create(result).assertNext(customers1 -> {
        }).verifyComplete();
    }

    @Test
    public void shouldSave() {
        final Mono<CustomerAnswersDetail> result = adapter.save(detail);
        StepVerifier.create(result).assertNext(response -> {
        }).verifyComplete();
    }

    @Test
    public void shouldFindAll() {
        StepVerifier.create(adapter.findById("3123QWERTY"))
                .assertNext(tasks -> assertThat(detail))
                .verifyComplete();
    }

}