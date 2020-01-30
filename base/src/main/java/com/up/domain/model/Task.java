package com.up.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "task")
@ToString(callSuper=true, includeFieldNames=true)
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public @Data class Task {

    public static enum TaskStatusType{
        TODO,
        IN_PROCESS,
        DONE
    }

    @Id
    private String id;

    @NotNull
    @Column(name = "description", nullable = false)
    private String name;

    @NotNull
    @Column(name = "creation_date", nullable = false)
    private Long creationDate;
    
    @NotNull
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private TaskStatusType value;

}