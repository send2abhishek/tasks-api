package com.coding.project.taksapi.repositories;

import com.coding.project.taksapi.domain.Task;
import com.coding.project.taksapi.repositories.custom.CustomTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task,Long> {


   List<CustomTask> findAllProjectedBy();

   List<CustomTask> findByUser_IdEquals(@NonNull Long id);

   List<CustomTask> readByUser_Id(@NonNull Long id);

   Optional<CustomTask> findByIdAndUser_Tasks_Id(Long taskId, Long userId);











}
