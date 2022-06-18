package com.sofka.retofinal.service;

import com.sofka.retofinal.model.TaskListModel;
import com.sofka.retofinal.repository.TaskListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskListService {

    @Autowired
    TaskListRepository taskListRepository;

    public Iterable<TaskListModel> getTaskList(){
        return taskListRepository.findAll();
    }

    public TaskListModel saveTaskList(TaskListModel taskListModel){
        return taskListRepository.save(taskListModel);
    }

    public Optional<TaskListModel> getTaskListById(Long id) {
        return taskListRepository.findById(id);
    }

    public TaskListModel updateTaskList(Long id, TaskListModel taskListModel) {
        taskListModel.setId(id);
        return taskListRepository.save(taskListModel);
    }

    public Boolean deleteTaskList(Long id) {
        try {
            taskListRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
