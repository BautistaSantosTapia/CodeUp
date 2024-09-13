package com.mindhub.todolist.services;

import com.mindhub.todolist.dtos.CreateUser;
import com.mindhub.todolist.dtos.UserDTO;
import com.mindhub.todolist.models.User;

import java.util.List;

public interface UserService{

    List<UserDTO> findAllUser();
    List<User> findAll();
    UserDTO createUser(CreateUser createUser);
    User findByEmail(String email);
}
