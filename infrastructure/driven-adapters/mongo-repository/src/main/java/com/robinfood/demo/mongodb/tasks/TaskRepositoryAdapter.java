package com.robinfood.demo.mongodb.tasks;


import com.robinfood.demo.entity.Task;
import com.robinfood.demo.reactive.repository.mongo.AdapterOperations;
import com.robinfood.demo.repository.TaskRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TaskRepositoryAdapter extends AdapterOperations<Task, TaskData, String, TaskDataRepository> implements TaskRepository {

    @Autowired
    public TaskRepositoryAdapter(TaskDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, Task.TaskBuilder.class).build());
    }
}