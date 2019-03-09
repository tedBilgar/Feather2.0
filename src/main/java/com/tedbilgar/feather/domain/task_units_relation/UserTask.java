package com.tedbilgar.feather.domain.task_units_relation;

import com.tedbilgar.feather.domain.task_units.Task;
import com.tedbilgar.feather.domain.units.User;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_task")
public class UserTask implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    private String role;

    public UserTask() {
    }

    public UserTask(User user, Task task, String role) {
        this.user = user;
        this.task = task;
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
