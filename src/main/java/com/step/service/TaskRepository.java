package com.step.service;

import com.step.entity.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> findByAuthor(String author);
    void deleteByAuthor(String author);
}
