package com.coding.project.taksapi.repositories.custom;

public interface CustomTaskAndUser {
    Long getId();
    String getTaskTitle();

    User getUser();



    interface User{
        String getEmail();
        Long getId();
        String getUserName();
    }
}
