package com.up.domain.service;

import java.util.List;

import com.up.domain.model.Task;

import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;

public interface ITaskService {
    
    public List<Task> findAll();

    public Page<Task> findPage(Pageable page);

    public Task findOne(String id);

    public Task save(Task data);

    public Task update(Task data) ;

    public Task delete(String id);

}