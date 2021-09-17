package com.survey.demo.repository;

import com.survey.demo.entity.Task;
import reactor.core.publisher.Mono;

public interface TaskRepository {
    Mono<Task> findById(String id);
    Mono<Task> save(Task task);
}
