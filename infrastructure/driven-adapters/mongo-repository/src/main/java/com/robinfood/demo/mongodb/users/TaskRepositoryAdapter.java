package com.robinfood.demo.mongodb.users;


import com.robinfood.demo.entity.Task;
import com.robinfood.demo.reactive.repository.mongo.AdapterOperations;
import com.robinfood.demo.repository.TaskRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class TaskRepositoryAdapter extends AdapterOperations<Task, TaskData, String, TaskDataRepository> implements TaskRepository {

    @Autowired
    public TaskRepositoryAdapter(TaskDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, Task.TaskBuilder.class).build());
    }

    @Override
    public Mono<Task> findByName(String var1) {
        return null;
    }

    @Override
    public Flux<Task> findAll() {
        return null;
    }

    @Override
    public Flux<Task> findAllByStatus(String var1) {
        return null;
    }

    @Override
    public Mono<Task> findById(String id) {
        return null;
    }

    @Override
    public Mono<Task> save(Task task) {
        return null;
    }
}