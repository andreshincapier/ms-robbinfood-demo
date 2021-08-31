package com.robinfood.demo.jpa.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface ConfigurationDataRepository extends CrudRepository<ConfigurationData, String>, QueryByExampleExecutor<ConfigurationData> {
    ConfigurationData findAllById(String id);
}
