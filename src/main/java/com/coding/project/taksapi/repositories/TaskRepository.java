package com.coding.project.taksapi.repositories;

import com.coding.project.taksapi.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
