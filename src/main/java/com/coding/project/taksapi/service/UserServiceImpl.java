package com.coding.project.taksapi.service;

import com.coding.project.taksapi.repositories.custom.CustomUser;
import com.coding.project.taksapi.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public CustomUser findAllUsers() {

        return  repository.findByPassword("12345");
    }
}
