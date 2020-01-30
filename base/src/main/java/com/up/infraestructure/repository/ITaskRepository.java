package com.up.infraestructure.repository;

import com.up.domain.model.Task;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface ITaskRepository extends CrudRepository<Task, String> {
    
    Page<Task> findAll(Pageable page);
}