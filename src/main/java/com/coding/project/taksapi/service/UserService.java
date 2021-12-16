package com.coding.project.taksapi.service;

import com.coding.project.taksapi.repositories.custom.CustomUser;

import java.util.List;

public interface UserService {

    List<CustomUser> findAllUsers();
}
