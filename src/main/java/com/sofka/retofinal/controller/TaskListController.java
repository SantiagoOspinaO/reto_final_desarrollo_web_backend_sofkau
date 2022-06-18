package com.sofka.retofinal.controller;

import com.sofka.retofinal.model.TaskListModel;
import com.sofka.retofinal.service.TaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin
@RequestMapping("/tasklist")
public class TaskListController {

    @Autowired
    TaskListService taskListService;

    @GetMapping()
    public List<TaskListModel> getTaskList() {
        return (ArrayList<TaskListModel>) taskListService.getTaskList();
    }

    @GetMapping(path = "/{id}")
    public Optional<TaskListModel> getTaskListById(@PathVariable("id") Long id) {
        return this.taskListService.getTaskListById(id);
    }

    @PostMapping()
    public TaskListModel saveTaskList(@RequestBody TaskListModel taskList) {
        return this.taskListService.saveTaskList(taskList);
    }

    @PutMapping("/{id}")
    public TaskListModel updateTaskList(@PathVariable("id") Long id, @RequestBody TaskListModel taskList) {
        return this.taskListService.updateTaskList(id, taskList);
    }

    @DeleteMapping("/{id}")
    public String deleteTaskList(@PathVariable("id") Long id) {
        boolean ok = this.taskListService.deleteTaskList(id);
        if (ok) {
            return "Se elimino la task list con id " + id;
        } else {
            return "No se pudo eliminar la task list con id" + id;
        }
    }
}
