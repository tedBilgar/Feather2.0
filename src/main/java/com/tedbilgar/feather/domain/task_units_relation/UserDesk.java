package com.tedbilgar.feather.domain.task_units_relation;

import com.tedbilgar.feather.domain.task_units.Desk;
import com.tedbilgar.feather.domain.units.User;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_desk")
public class UserDesk implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "desk_id")
    private Desk desk;

    private String role;

    public UserDesk() {
    }

    public UserDesk(User user, Desk desk, String role) {
        this.user = user;
        this.desk = desk;
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Desk getDesk() {
        return desk;
    }

    public void setDesk(Desk desk) {
        this.desk = desk;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
