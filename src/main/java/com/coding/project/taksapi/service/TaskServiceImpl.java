package com.coding.project.taksapi.service;

import com.coding.project.taksapi.domain.Task;
import com.coding.project.taksapi.domain.User;
import com.coding.project.taksapi.repositories.TaskRepository;
import com.coding.project.taksapi.repositories.custom.CustomTask;
import com.coding.project.taksapi.web.exceptionHandler.NotFoundException;
import com.coding.project.taksapi.web.mapper.TaskMapper;
import com.coding.project.taksapi.web.model.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;

        this.taskMapper = taskMapper;
    }

    @Override
    public List<CustomTask> findAllTasksByUserId(Long userId) {
        return taskRepository.readByUser_Id(userId);
    }

    @Override
    public CustomTask findTaskByTaskIdAndUserId(Long taskId, Long userId) {
        return taskRepository.findByIdAndUser_Tasks_Id(taskId, userId).orElseThrow(NotFoundException::new);
    }

    @Override
    public Optional<Task> findTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task saveTask(TaskDto task) {
        return taskRepository.save(Task.builder().
                user(User.builder()
                        .id(task.getUserId())
                        .build()).
                taskTitle(task.getTaskTitle()).taskDesc(task.getTaskDesc()).build());
    }


}
