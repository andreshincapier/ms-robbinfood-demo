package com.survey.demo.mongodb.tasks;

import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;


public interface TaskDataRepository extends ReactiveCrudRepository<TaskData, String>, ReactiveQueryByExampleExecutor<TaskData> {
}
