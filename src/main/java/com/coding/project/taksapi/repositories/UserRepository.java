package com.coding.project.taksapi.repositories;

import com.coding.project.taksapi.domain.User;
import com.coding.project.taksapi.repositories.custom.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    CustomUser findByPassword(String title);
}
