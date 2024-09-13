package com.mindhub.todolist.dtos;

import com.mindhub.todolist.models.Task;

public class TaskDTO {
    private Long id;
    private String title;
    private String description;
    public enum status {
        PENDING,
        IN_PROGRESS,
        COMPLETED
    }

    public TaskDTO() {}

    public TaskDTO(Task task) {
        id = task.getId();
        title = task.getTitle();
        description = task.getDescription();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
