package com.tedbilgar.feather.domain.task_units;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "desk")
public class Desk {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "desk", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TaskList> taskLists;

    public Desk() {
    }

    public Desk(String name, List<TaskList> taskLists) {
        this.name = name;
        this.taskLists = taskLists;
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

    public List<TaskList> getTaskLists() {
        return taskLists;
    }

    public void setTaskLists(List<TaskList> taskLists) {
        this.taskLists = taskLists;
    }
}
