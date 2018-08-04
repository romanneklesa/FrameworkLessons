package com.frameworks.lessons.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int role_id;

    @Column(name = "role", unique = true)
    private String role;



    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        role_id = role_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        role = role;
    }


    @Override
    public String toString() {
        return "Role{" +
                "role_id=" + role_id +
                ", role='" + role + '\'' +
                '}';
    }
}
