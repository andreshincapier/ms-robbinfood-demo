package com.survey.demo.tasks;

import reactor.core.publisher.Mono;

public interface TaskRepository {

    Mono<Task> findById(String id);
    Mono<Task> save(Task task);
}
