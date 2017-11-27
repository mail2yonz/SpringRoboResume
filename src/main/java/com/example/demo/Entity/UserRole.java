package com.example.demo.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    @NotNull
    private String role;



    @ManyToMany(mappedBy = "roles",fetch = FetchType.LAZY)
    private Set<UserData> users;

    public UserRole(String role, Set<UserData> users) {
        this.role = role;
        this.users = users;
    }


    public UserRole()
    {
        users= new HashSet<>();
    }

    public UserRole(String role) {
        role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<UserData> getUsers() {
        return users;
    }

    public void setUsers(Set<UserData> users) {
        this.users = users;
    }
}
