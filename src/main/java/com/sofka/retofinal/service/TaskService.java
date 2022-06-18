package com.sofka.retofinal.service;

import com.sofka.retofinal.model.TaskModel;
import com.sofka.retofinal.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public List<TaskModel> getTask() {
        return (List<TaskModel>) taskRepository.findAll();
    }

    public Optional<TaskModel> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public TaskModel saveTask(TaskModel taskModel) {
        return taskRepository.save(taskModel);
    }

    public TaskModel updateTask(Long id, TaskModel taskModel) {
        taskModel.setId(id);
        return taskRepository.save(taskModel);
    }

    public Boolean deleteTask(Long id) {
        try {
            taskRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
