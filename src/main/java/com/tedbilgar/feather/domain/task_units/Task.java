package com.tedbilgar.feather.domain.task_units;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String discription;
    private Date start_time;
    private Date end_time;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "taskList_id")
    private TaskList taskList;


    public Task() {
    }

    public Task(String name, String discription, Date start_time, Date end_time, TaskList taskList) {
        this.name = name;
        this.discription = discription;
        this.start_time = start_time;
        this.end_time = end_time;
        this.taskList = taskList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public TaskList getTaskList() {
        return taskList;
    }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }
}
