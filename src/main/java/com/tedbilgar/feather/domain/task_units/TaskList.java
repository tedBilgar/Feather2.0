package com.tedbilgar.feather.domain.task_units;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tedbilgar.feather.domain.task_units_relation.UserTaskList;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "task_list")
public class TaskList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    private String name;
    private String discription;
    private Date start_time;
    private Date end_time;

    @OneToMany(mappedBy = "taskList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Task> tasks;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "desk_id")
    @JsonIgnore
    private Desk desk;

    @OneToMany(mappedBy = "taskList", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<UserTaskList> userTaskLists = new HashSet<>();

    public TaskList() {
    }

    public TaskList(String name, String discription, Date start_time, Date end_time, List<Task> tasks) {
        this.name = name;
        this.discription = discription;
        this.start_time = start_time;
        this.end_time = end_time;
        this.tasks = tasks;
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

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public Desk getDesk() {
        return desk;
    }

    public void setDesk(Desk desk) {
        this.desk = desk;
    }

    public Set<UserTaskList> getUserTaskLists() {
        return userTaskLists;
    }

    public void setUserTaskLists(Set<UserTaskList> userTaskLists) {
        this.userTaskLists = userTaskLists;
    }
}
