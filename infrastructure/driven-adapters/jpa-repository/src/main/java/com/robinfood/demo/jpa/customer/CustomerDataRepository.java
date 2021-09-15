package com.robinfood.demo.jpa.customer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;


public interface CustomerDataRepository extends CrudRepository<CustomerData, String>, QueryByExampleExecutor<CustomerData> {
}
