package com.jwt.model;

import javax.persistence.*;

@Entity
public class Role {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_role", nullable = false)
    private int id_role;
    @Column(name = "name")
    private String name;

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id_role=" + id_role +
                ", name='" + name + '\'' +
                '}';
    }
}
