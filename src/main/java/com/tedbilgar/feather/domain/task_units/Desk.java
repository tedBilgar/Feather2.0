package com.tedbilgar.feather.domain.task_units;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tedbilgar.feather.domain.task_units_relation.UserDesk;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "desk")
public class Desk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "desk", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TaskList> taskLists;

    @OneToMany(mappedBy = "desk", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<UserDesk> userDesks = new HashSet<>();

    public Desk() {
    }

    public Desk(String name, List<TaskList> taskLists, Set<UserDesk> userDesks) {
        this.name = name;
        this.taskLists = taskLists;
        this.userDesks = userDesks;
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
