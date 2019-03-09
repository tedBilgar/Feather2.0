package com.tedbilgar.feather.domain.task_units_relation;

import com.tedbilgar.feather.domain.task_units.TaskList;
import com.tedbilgar.feather.domain.units.User;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_tasklist")
public class UserTaskList implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "tasklist_id")
    private TaskList taskList;

    private String role;

    public UserTaskList() {
    }

    public UserTaskList(User user, TaskList taskList, String role) {
        this.user = user;
        this.taskList = taskList;
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TaskList getTaskList() {
        return taskList;
    }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
