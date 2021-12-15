package com.coding.project.taksapi.web.controller;

import com.coding.project.taksapi.domain.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomTasks {

    private Long id;
    private String taskTitle;
    private String userName;
    private Long userId;
 }
