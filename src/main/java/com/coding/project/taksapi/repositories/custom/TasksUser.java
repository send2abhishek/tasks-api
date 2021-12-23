package com.coding.project.taksapi.repositories.custom;

import java.sql.Timestamp;

public interface TasksUser {

    Long getId();
    String getTaskTitle();
    String getTaskDesc();
    User getUser();
    Timestamp getLastModifiedDate();

    interface User{
        Long getId();
        String getEmail();
        String getUserName();
    }
}
