package com.coding.project.taksapi.repositories.custom;

import java.sql.Timestamp;

public interface CustomTask {
    Long getId();
    String getTaskTitle();
    String getTaskDesc();
    User getUser();
    Timestamp getLastModifiedDate();

    interface User{
        String getEmail();
        String getUserName();
    }
}
