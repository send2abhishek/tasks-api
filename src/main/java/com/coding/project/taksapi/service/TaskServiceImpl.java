package com.coding.project.taksapi.service;

import com.coding.project.taksapi.domain.Task;
import com.coding.project.taksapi.repositories.TaskRepository;
import com.coding.project.taksapi.repositories.custom.CustomTask;
import com.coding.project.taksapi.repositories.custom.TasksUser;
import com.coding.project.taksapi.web.exceptionHandler.NotFoundException;
import com.coding.project.taksapi.web.mapper.TaskMapper;
import com.coding.project.taksapi.web.model.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<TasksUser> findALlTasks() {
        return taskRepository.findAllProjectedBy();
    }

    @Override
    public List<CustomTask> findAllTasksByUserId(Long userId) {
        List<CustomTask> customTasks = taskRepository.readByUser_Id(userId);
        return customTasks;
    }

    @Override
    public CustomTask findTaskByTaskIdAndUserId(Long taskId, Long userId) {
        return taskRepository.findByIdAndUser_Tasks_Id(taskId, userId).orElseThrow(() -> new NotFoundException("task not found with given task id"));
    }

    @Override
    public Optional<Task> findTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task saveTask(TaskDto task) {
        return taskRepository.save(taskMapper.taskDtoToTask(task));
    }

    @Transactional
    @Override
    public TaskDto updateTask(TaskDto task, Long taskId) {

        Task foundTask = taskRepository.findById(taskId).orElseThrow(() -> new NotFoundException("task not found with given task id"));
        if (foundTask != null) {
            foundTask.setTaskTitle(task.getTaskTitle());
            foundTask.setTaskDesc(task.getTaskDesc());
            taskRepository.save(foundTask);
        }

        return task;
    }

    @Override
    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }


}
