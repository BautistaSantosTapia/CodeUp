package com.mindhub.todolist.services.impl;

import com.mindhub.todolist.dtos.CreateTask;
import com.mindhub.todolist.dtos.TaskDTO;
import com.mindhub.todolist.handlers.TaskNotFound;
import com.mindhub.todolist.models.Task;
import com.mindhub.todolist.models.User;
import com.mindhub.todolist.repositories.TaskRepository;
import com.mindhub.todolist.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class TaskServiceImpl implements TaskService {

    @Autowired
    private User user;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<TaskDTO> findAllTask(){
        return findAll().stream().map(TaskDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    @Override
    public TaskDTO createTask(CreateTask createTask){
        Task task = new Task(createTask.title(), createTask.description(),user);
        taskRepository.save(task);
        return new TaskDTO(task);
    }

    @Override
    public Task findByTitle(String title) {
        return taskRepository.findByTitle(title).orElseThrow(()-> new TaskNotFound("No se encontro la task con el titulo: "+ title));
    }

    @Override
    public Task findById(Long id) {
        return taskRepository.findById(id).orElseThrow(()-> new TaskNotFound("No se encontro la task con el id: "+ id));
    }

}
