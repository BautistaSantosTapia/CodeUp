package com.mindhub.todolist.services;

import com.mindhub.todolist.dtos.CreateTask;
import com.mindhub.todolist.dtos.TaskDTO;
import com.mindhub.todolist.models.Task;

import java.util.List;

public interface TaskService {


    List<TaskDTO> findAllTask();
    List<Task> findAll();
    TaskDTO createTask(CreateTask createTask);
    Task findByTitle(String title);
    Task findById(Long id);
}
