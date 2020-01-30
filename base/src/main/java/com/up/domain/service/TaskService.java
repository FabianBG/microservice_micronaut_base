package com.up.domain.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.inject.Singleton;

import com.up.domain.model.Task;
import com.up.domain.model.Task.TaskStatusType;
import com.up.infraestructure.repository.ITaskRepository;

import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;

@Singleton
public class TaskService implements ITaskService{
    
    protected final ITaskRepository TaskRepository;

    public TaskService(final ITaskRepository TaskRepository) { 
        this.TaskRepository = TaskRepository;
    }

    @Override
    public List<Task> findAll() {
        final Iterable<Task> iter = this.TaskRepository.findAll();
        return StreamSupport.stream(iter.spliterator(), false)
        .collect(Collectors.toList());
    }

    @Override
    public Page<Task> findPage(Pageable page) {
        return this.TaskRepository.findAll(page);
    }

    @Override
    public Task findOne(String id) {
        return this.TaskRepository.findById(id).orElse(null);
    }

    @Override
    public Task save(Task data) {
        UUID uuid = UUID.randomUUID();
        data.setId(uuid.toString());
        data.setCreationDate(new Date().getTime());
        data.setStatus(TaskStatusType.TODO);
        return this.TaskRepository.save(data);
    }

    @Override
    public Task update(Task data) {
        return this.TaskRepository.update(data);
    }

    @Override
    public Task delete(String id) {
        Task p = this.TaskRepository.findById(id).orElse(null);;
        this.TaskRepository.deleteById(id);
        return p;
    }

}