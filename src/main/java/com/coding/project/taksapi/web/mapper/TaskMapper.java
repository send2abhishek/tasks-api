package com.coding.project.taksapi.web.mapper;

import com.coding.project.taksapi.domain.Task;
import com.coding.project.taksapi.web.model.TaskDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {


    Task taskDtoToTask(TaskDto taskDto);
}
