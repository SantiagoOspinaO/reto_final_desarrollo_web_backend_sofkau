package com.sofka.retofinal.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "task")
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    @Column(nullable = false)
    private String task;
    @Column(nullable = false)
    private boolean completed;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = TaskListModel.class)
    @JoinColumn(name = "task_list_id")
    @JsonBackReference
    private TaskListModel taskList;

    public TaskModel() {
    }

    public TaskModel(Long id, String task, boolean completed) {
        this.id = id;
        this.task = task;
        this.completed = completed;
    }
}
