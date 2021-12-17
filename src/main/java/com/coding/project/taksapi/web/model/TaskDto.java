package com.coding.project.taksapi.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDto implements Serializable {

    static final long serialVersionUID= -4908854647353847926L;

    private Long userId;
    private String taskTitle;
    private String taskDesc;

}
