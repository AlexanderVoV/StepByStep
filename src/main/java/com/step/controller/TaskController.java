package com.step.controller;

import com.google.common.base.Strings;
import com.step.entity.Task;
import com.step.service.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping(value = "/task")
@CrossOrigin(origins = "http://localhost:9000")
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

//    @CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        task.setCreationDate(Calendar.getInstance());
        task.setAuthor(Strings.isNullOrEmpty(task.getAuthor()) ? "User" : task.getAuthor());
        return new ResponseEntity<>(taskRepository.save(task), HttpStatus.OK);
    }

//    @CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Task> updateTask(@RequestBody Task task) {
        task.setCreationDate(Calendar.getInstance());
        return new ResponseEntity<>(taskRepository.save(task), HttpStatus.OK);
    }

//    @CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Iterable<Task> all() {
        return taskRepository.findAll();
    }

//    @CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Task getTaskById(@PathVariable Long id) {
        return taskRepository.findOne(id);
    }

//    @CrossOrigin(origins = "http://localhost:9000")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteTask(@PathVariable Long id) {
        taskRepository.delete(id);
    }

    @RequestMapping(value = "/delete/all/{author}", method = RequestMethod.DELETE)
    public void deleteTasksByAuthor(@PathVariable String author) {
        taskRepository.deleteByAuthor(author);
    }
}
