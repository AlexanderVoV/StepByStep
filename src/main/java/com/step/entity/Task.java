package com.step.entity;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name="TASKS")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "creation_date")
    private Calendar creationDate;
    @Column(name = "author")
    private String author;
    @Column(name = "content")
    private String content;

    public Task() {}
    public Task(Calendar creationDate, String content) {
        this.creationDate = creationDate;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Calendar creationDate) {
        this.creationDate = creationDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
