package com.tedbilgar.feather.domain.units;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_groups")
public class UserGroup implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn
    private Group group;

    @Id
    @ManyToOne
    @JoinColumn
    private User user;

    private String role;

    public UserGroup() {
    }

    public UserGroup(User user, Group group, String role) {
        this.user = user;
        this.group = group;
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
