package com.mindhub.todolist.dtos;

import com.mindhub.todolist.models.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserDTO {

    private Long id;
    private String username, email;
    private List<TaskDTO> tasks;

    public UserDTO(){}
    public UserDTO(User user){
        id = user.getId();
        username = user.getUsername();
        email = user.getEmail();
        tasks = user.getTasks().stream().map(t -> new TaskDTO(t)).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public List<TaskDTO> getTasks() {
        return tasks;
    }
}
