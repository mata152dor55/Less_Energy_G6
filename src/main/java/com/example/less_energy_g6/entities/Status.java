package com.example.less_energy_g6.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idStatus;

    @Column(name = "nameState", length = 20, nullable = false)
    private String nameStatus;

    @Column(name = "description", length = 100, nullable = true)
    private String description;

    public Status() {
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public String getNameStatus() {
        return nameStatus;
    }

    public void setNameStatus(String nameStatus) {
        this.nameStatus = nameStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
