package com.mindhub.todolist.controllers;


import com.mindhub.todolist.dtos.TaskDTO;
import com.mindhub.todolist.handlers.TaskNotFound;
import com.mindhub.todolist.models.Task;
import com.mindhub.todolist.models.User;
import com.mindhub.todolist.repositories.TaskRepository;
import com.mindhub.todolist.repositories.UserRepository;
import com.mindhub.todolist.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;


    @GetMapping
    public List<Task> getAll(){
        return taskRepository.findAll();
    }

    @GetMapping("/{id}")
    public Task getById(@PathVariable Long id){
        return taskRepository.findById(id).orElseThrow( () -> new TaskNotFound("No se encontro el task con el id: " + id));
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> createTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO){
        User user = userRepository.findById(id).orElseThrow(()-> new RuntimeException());

        Task task = new Task(taskDTO.getTitle(), taskDTO.getDescription(),user);
        user.addTasks(task);
        taskRepository.save(task);
        return ResponseEntity.ok().body("Task creada");
    };

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        if (!taskRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        taskRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
