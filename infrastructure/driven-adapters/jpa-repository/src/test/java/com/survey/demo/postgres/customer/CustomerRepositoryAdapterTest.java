package com.survey.demo.postgres.customer;

import com.survey.demo.entity.Customers;
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
public class CustomerRepositoryAdapterTest {

    private final Customers customers = Customers.builder().id("3123QWERTY").name("John").lastName("Doe").phone(3892389L).email("algo@test.com").status("ACTIVE").build();
    private final Customers customers2 = Customers.builder().id("3123QWERTY2").name("John 2").lastName("Doe 2").phone(3892389L).email("algo2@test.com").status("ACTIVE").build();

    @Autowired
    private CustomerRepositoryAdapter adapter;

    @Before
    public void saveInitialData() {
        final Mono<Customers> result = adapter.save(customers).then(adapter.save(customers2));
        StepVerifier.create(result).assertNext(customers1 -> {
        }).verifyComplete();
    }

    @Test
    public void shouldSave() {
        final Mono<Customers> result = adapter.save(customers);
        StepVerifier.create(result).assertNext(customers1 -> {
        }).verifyComplete();
    }

    @Test
    public void shouldFindAll() {
        StepVerifier.create(adapter.findById("3123QWERTY"))
                .assertNext(tasks -> assertThat(customers))
                .verifyComplete();
    }

}