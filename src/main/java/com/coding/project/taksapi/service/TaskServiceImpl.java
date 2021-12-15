package com.coding.project.taksapi.service;

import com.coding.project.taksapi.domain.Task;
import com.coding.project.taksapi.repositories.custom.CustomTaskAndUser;
import com.coding.project.taksapi.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public CustomTaskAndUser findAllTasks() {
      //  System.out.println("demo"+taskRepository.findByTaskTitle("Demo"));
//        return taskRepository.findAll().stream()
//                .map(task -> CustomTasks.builder()
//                        .taskTitle(task.getTaskTitle())
//                        .id(task.getId())
//                        .userName(task.getUser().getUserName())
//                        .userId(task.getUser().getId())
//                        .build()).collect(Collectors.toList());

        return taskRepository.findByTaskTitle("Demo");
    }

    @Override
    public Optional<Task> findTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }
}
