package com.sofka.retofinal.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "tasklist")
public class TaskListModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "taskList",
            targetEntity = TaskModel.class,
            fetch = FetchType.EAGER,
            cascade = CascadeType.REMOVE)
    @JsonManagedReference
    private List<TaskModel> taskModelList;

    public TaskListModel() {
    }

    public TaskListModel(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
