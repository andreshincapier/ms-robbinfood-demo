package com.robinfood.demo.jpa.customer;

import com.robinfood.demo.entity.Customers;
import com.robinfood.demo.reactive.repository.jpa.AdapterOperations;
import com.robinfood.demo.repository.CustomersRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryAdapter extends AdapterOperations<Customers, CustomerData, String, CustomerDataRepository> implements CustomersRepository {

    @Autowired
    public CustomerRepositoryAdapter(CustomerDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, Customers.CustomersBuilder.class).build());
    }
}