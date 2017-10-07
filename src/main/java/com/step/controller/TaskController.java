package com.step.controller;

import com.google.common.base.Strings;
import com.step.entity.Task;
import com.step.service.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Calendar;

@RestController
@RequestMapping(value = "/task")
@CrossOrigin(origins = "http://192.168.1.101:9000")
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        task.setCreationDate(Calendar.getInstance());
        task.setAuthor(Strings.isNullOrEmpty(task.getAuthor()) ? "User" : task.getAuthor());
        return new ResponseEntity<>(taskRepository.save(task), HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Task> updateTask(@RequestBody Task task) {
        task.setCreationDate(Calendar.getInstance());
        return new ResponseEntity<>(taskRepository.save(task), HttpStatus.OK);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Iterable<Task> all() {
        return taskRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Task getTaskById(@PathVariable String id) {
        return taskRepository.findOne(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteTask(@PathVariable String id) {
        taskRepository.delete(id);
    }

    @RequestMapping(value = "/delete/all/{author}", method = RequestMethod.DELETE)
    public void deleteTasksByAuthor(@PathVariable String author) {
        taskRepository.deleteByAuthor(author);
    }
}
