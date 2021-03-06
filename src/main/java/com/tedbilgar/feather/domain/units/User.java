package com.tedbilgar.feather.domain.units;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tedbilgar.feather.domain.roles.Role;
import com.tedbilgar.feather.domain.task_units_relation.UserDesk;
import com.tedbilgar.feather.domain.task_units_relation.UserTask;
import com.tedbilgar.feather.domain.task_units_relation.UserTaskList;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usr")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    private String username;
    private String password;
    private boolean active;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<UserGroup> userGroups = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<UserDesk> userDesks = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<UserTaskList> userTaskLists = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<UserTask> userTasks = new HashSet<>();


    public User() {
    }

    public User(String username, String password, boolean active, Set<Role> roles, Set<UserGroup> userGroups, Set<UserDesk> userDesks, Set<UserTaskList> userTaskLists, Set<UserTask> userTasks) {
        this.username = username;
        this.password = password;
        this.active = active;
        this.roles = roles;
        this.userGroups = userGroups;
        this.userDesks = userDesks;
        this.userTaskLists = userTaskLists;
        this.userTasks = userTasks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<UserGroup> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(Set<UserGroup> userGroups) {
        this.userGroups = userGroups;
    }

    public Set<UserDesk> getUserDesks() {
        return userDesks;
    }

    public void setUserDesks(Set<UserDesk> userDesks) {
        this.userDesks = userDesks;
    }

    public Set<UserTaskList> getUserTaskLists() {
        return userTaskLists;
    }

    public void setUserTaskLists(Set<UserTaskList> userTaskLists) {
        this.userTaskLists = userTaskLists;
    }

    public Set<UserTask> getUserTasks() {
        return userTasks;
    }

    public void setUserTasks(Set<UserTask> userTasks) {
        this.userTasks = userTasks;
    }
}
