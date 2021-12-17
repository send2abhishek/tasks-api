package com.coding.project.taksapi.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDto implements Serializable {

    static final long serialVersionUID= -4908854647353847926L;

    @NotNull(message = "user id can't be blank")
    private Long userId;
    @Size(min = 2,message = "it should be greater than 2")
    private String taskTitle;
    @NotBlank(message = "task description is needed")
    private String taskDesc;



}
