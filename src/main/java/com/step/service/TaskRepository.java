package com.step.service;

import com.step.entity.Task;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

@Configuration
public interface TaskRepository extends MongoRepository<Task, String> {
    List<Task> findByAuthor(String author);
    void deleteByAuthor(String author);
}
