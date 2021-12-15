package com.coding.project.taksapi.repositories.custom;

import java.util.List;

public interface CustomUser {

    String getPassword();
    List<Task> getTasks();

    interface Task{
        String getTaskTitle();
    }
}
