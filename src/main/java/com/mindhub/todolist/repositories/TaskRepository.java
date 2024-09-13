package com.mindhub.todolist.repositories;

import com.mindhub.todolist.models.Task;
import com.mindhub.todolist.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<Task> findByTitle(String title);

    Optional<Task> findById(Long id);

    boolean existsById(Long id);
}
