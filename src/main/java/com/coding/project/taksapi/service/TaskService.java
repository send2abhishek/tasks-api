package com.coding.project.taksapi.service;

import com.coding.project.taksapi.domain.Task;
import com.coding.project.taksapi.repositories.custom.CustomTask;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    List<CustomTask> findAllTasksByUserId(Long userId);

    CustomTask findTaskByTaskIdAndUserId(Long taskId, Long userId);

    Optional<Task> findTaskById(Long id);

    Task saveTask(Task task);


}
