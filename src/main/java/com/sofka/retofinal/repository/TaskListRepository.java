package com.sofka.retofinal.repository;

import com.sofka.retofinal.model.TaskListModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskListRepository extends CrudRepository<TaskListModel, Long> {

}
