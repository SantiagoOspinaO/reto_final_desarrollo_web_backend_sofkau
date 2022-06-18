package com.sofka.retofinal.controller;

import com.sofka.retofinal.model.TaskModel;
import com.sofka.retofinal.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping()
    public List<TaskModel> getTask() {
        return taskService.getTask();
    }

    @GetMapping("/{id}")
    public Optional<TaskModel> getTaskById(@PathVariable("id") Long id) {
        return this.taskService.getTaskById(id);
    }

    @PostMapping()
    public TaskModel saveTask(@RequestBody TaskModel taskModel) {
        return this.taskService.saveTask(taskModel);
    }

    @PutMapping("/{id}")
    public TaskModel updateTask(@PathVariable("id") Long id, @RequestBody TaskModel taskModel) {
        return this.taskService.updateTask(id, taskModel);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable("id") Long id) {
        boolean ok = this.taskService.deleteTask(id);
        if (ok) {
            return "Se elimino la task " + id;
        } else {
            return "No se pudo eliminar la task " + id;
        }
    }
}
