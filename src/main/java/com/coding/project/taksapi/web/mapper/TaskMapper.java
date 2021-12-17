package com.coding.project.taksapi.web.mapper;

import com.coding.project.taksapi.domain.Task;
import com.coding.project.taksapi.web.model.TaskDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Mapping(target = "user.id",source = "userId")
    Task taskDtoToTask(TaskDto taskDto);
}
