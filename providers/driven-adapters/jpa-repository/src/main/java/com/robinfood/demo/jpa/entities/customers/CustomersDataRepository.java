package com.robinfood.demo.jpa.entities.customers;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;


public interface CustomersDataRepository extends CrudRepository<CustomersData, String>, QueryByExampleExecutor<CustomersData> {
}
