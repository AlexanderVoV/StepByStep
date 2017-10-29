package com.step.service;

import com.step.entity.Task;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {
}
