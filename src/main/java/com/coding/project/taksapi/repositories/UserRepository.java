package com.coding.project.taksapi.repositories;

import com.coding.project.taksapi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
