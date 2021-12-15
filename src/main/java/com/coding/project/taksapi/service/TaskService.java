package com.coding.project.taksapi.service;

import com.coding.project.taksapi.domain.Task;
import com.coding.project.taksapi.repositories.custom.CustomTaskAndUser;

import java.util.Optional;

public interface TaskService {

    CustomTaskAndUser findAllTasks();

    Optional<Task> findTaskById(Long id);

    Task saveTask(Task task);


}
