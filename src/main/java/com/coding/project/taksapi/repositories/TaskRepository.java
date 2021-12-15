package com.coding.project.taksapi.repositories;

import com.coding.project.taksapi.domain.Task;
import com.coding.project.taksapi.repositories.custom.CustomTaskAndUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {

    CustomTaskAndUser findByTaskTitle(String title);
}
