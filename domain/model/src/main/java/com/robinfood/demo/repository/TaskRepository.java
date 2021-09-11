package com.robinfood.demo.repository;

import com.robinfood.demo.entity.Task;
import reactor.core.publisher.Mono;

public interface TaskRepository extends PersistenceDataRepository<Task, Task> {
    Mono<Task> findById(String id);
    Mono<Task> save(Task task);
}
