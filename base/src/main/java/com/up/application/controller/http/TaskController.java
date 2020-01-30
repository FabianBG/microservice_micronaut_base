package com.up.application.controller.http;

import java.net.URI;

import javax.validation.Valid;

import com.up.domain.model.Task;
import com.up.domain.service.TaskService;

import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.annotation.QueryValue;

@Controller("/task") 
public class TaskController {

    protected final TaskService TaskService;

    public TaskController(final TaskService TaskService) { 
        this.TaskService = TaskService;
    }

    @Get("/{id}") 
    public Task findOne(final String id) {
        return this.TaskService
                .findOne(id); 
    }

    @Get 
    public Iterable<Task> getAll() {
        return this.TaskService.findAll();
    }

    @Get("/page")
    public Page<Task> getPage(
        @QueryValue("page") Integer page,
        @QueryValue("size") Integer size
        ) {
            return this.TaskService.findPage(Pageable.from(page, size));
    }

    @Post() 
    public Task insert(final Task data) {
        return this.TaskService.save(data);
    }

    @Put() 
    public Task update(@Valid final Task data) {
        return this.TaskService.update(data);
    }

    @Delete("/{id}") 
    public Task delete(final String id) {
        return this.TaskService.delete(id);
    }

    protected URI location(final String id) {
        return URI.create("/task/" + id);
    }

    protected URI location(final Task Task) {
        return location(Task.getId());
    }
}