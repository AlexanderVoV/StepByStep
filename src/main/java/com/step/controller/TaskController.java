package com.step.controller;

import com.google.common.base.Strings;
import com.step.entity.Task;
import com.step.service.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping(value = "/task")
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public Task getNewDefaultTask() {
        Task task = new Task();
        task.setCreationDate(Calendar.getInstance());
        task.setAuthor("Alex");
        task.setContent("Default");

        return taskRepository.save(task);
    }

    @RequestMapping(value = "/new/{author}/{content}", method = RequestMethod.GET)
    public Task getNewTask(@PathVariable String author, @PathVariable String content) {

        Task task = new Task();
        task.setCreationDate(Calendar.getInstance());
        task.setAuthor(Strings.isNullOrEmpty(author) ? "User" : author);
        task.setContent(content);

        return taskRepository.save(task);
    }

    @CrossOrigin(origins = "http://localhost:9000")
    @GetMapping("/all")
    public Iterable<Task> all() {
        return taskRepository.findAll();
    }

    @RequestMapping(value = "/{author}", method = RequestMethod.GET)
    public List<Task> getAllTasksByAuthor(@PathVariable String author) {
        return taskRepository.findByAuthor(author);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteTask(@PathVariable Long id) {
        taskRepository.delete(id);
    }

    @RequestMapping(value = "/delete/all/{author}", method = RequestMethod.DELETE)
    public void deleteTasksByAuthor(@PathVariable String author) {
        taskRepository.deleteByAuthor(author);
    }
}
