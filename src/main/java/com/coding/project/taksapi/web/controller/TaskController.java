package com.coding.project.taksapi.web.controller;

import com.coding.project.taksapi.domain.Task;
import com.coding.project.taksapi.repositories.custom.CustomTaskAndUser;
import com.coding.project.taksapi.repositories.custom.CustomUser;
import com.coding.project.taksapi.service.TaskService;
import com.coding.project.taksapi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;


    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @GetMapping("tasks")
    public ResponseEntity<CustomTaskAndUser> getTasks() {
        return new ResponseEntity<>(taskService.findAllTasks(), HttpStatus.OK);
    }

    @GetMapping("users")
    public ResponseEntity<CustomUser> getUsers() {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @GetMapping("tasks/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        return new ResponseEntity<>(taskService.findTaskById(id).get(), HttpStatus.OK);
    }

    @PostMapping("tasks")
    public ResponseEntity<Task> saveTasks(@RequestBody Task task) {
        return new ResponseEntity<>(taskService.saveTask(task), HttpStatus.CREATED);
    }
}
