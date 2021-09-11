package com.robinfood.demo.mongodb.users;

import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;


public interface TaskDataRepository extends ReactiveCrudRepository<TaskData, String>, ReactiveQueryByExampleExecutor<TaskData> {
}
