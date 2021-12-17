package com.coding.project.taksapi.web.controller;

import com.coding.project.taksapi.domain.Task;
import com.coding.project.taksapi.repositories.custom.CustomTask;
import com.coding.project.taksapi.repositories.custom.CustomUser;
import com.coding.project.taksapi.service.TaskService;
import com.coding.project.taksapi.service.UserService;
import com.coding.project.taksapi.web.model.TaskDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;


    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @GetMapping("tasks/{userId}")
    public ResponseEntity<List<CustomTask>> getTasks(@PathVariable Long userId) {
        return new ResponseEntity<>(taskService.findAllTasksByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("tasks/{taskId}/{userId}")
    public ResponseEntity<CustomTask> getTasksByTaskIdAndUserId(@PathVariable Long taskId,@PathVariable Long userId) {
        return new ResponseEntity<>(taskService.findTaskByTaskIdAndUserId(taskId,userId), HttpStatus.OK);
    }

    @GetMapping("users")
    public ResponseEntity<List<CustomUser>> getUsers() {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @PostMapping("tasks")
    public ResponseEntity<Task> saveTasks(@RequestBody TaskDto task) {

        return new ResponseEntity<>(taskService.saveTask(task), HttpStatus.CREATED);
    }
}
