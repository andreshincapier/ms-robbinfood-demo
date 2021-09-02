package com.robinfood.demo.jpa.entities.customers;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;


public interface JpaCustomersRepository extends CrudRepository<CustomersEntity, String>, QueryByExampleExecutor<CustomersEntity> {
    List<CustomersEntity> findAllByStatus(String status);
}
