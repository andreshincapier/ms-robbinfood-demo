package com.robinfood.demo.postgres.customer;

import com.robinfood.demo.entity.Customers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryAdapterTest {

    private final Customers customers = Customers.builder().id("3123QWERTY").name("John").lastName("Doe").phone(3892389L).email("algo@test.com").status("ACTIVE").build();

    @Autowired
    private CustomerRepositoryAdapter adapter;


    @Test
    public void saveInitialData() {
        final Mono<Customers> result = adapter.save(customers);
        StepVerifier.create(result).assertNext(customers1 -> {
        }).verifyComplete();
    }

}