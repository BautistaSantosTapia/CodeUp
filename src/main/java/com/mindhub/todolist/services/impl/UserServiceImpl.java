package com.mindhub.todolist.services.impl;

import com.mindhub.todolist.dtos.CreateUser;
import com.mindhub.todolist.dtos.UserDTO;
import com.mindhub.todolist.handlers.UserNotFound;
import com.mindhub.todolist.models.User;
import com.mindhub.todolist.repositories.UserRepository;
import com.mindhub.todolist.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> findAllUser(){
        return findAll().stream().map(UserDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Override
    public UserDTO createUser(CreateUser createUser){
        User user = new User(createUser.username(),createUser.email(), createUser.password());
        userRepository.save(user);
        return new UserDTO(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(()-> new UserNotFound("No se encontro el usuario con el email: "+ email));
    }


}
