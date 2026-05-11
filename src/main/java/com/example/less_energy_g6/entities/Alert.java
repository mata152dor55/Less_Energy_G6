package com.example.less_energy_g6.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table (name = "Alert")
public class Alert {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idAlert;

    @Column (name = "description", nullable = false)
    private String description;

    @Column(name = "dateCreation", nullable = false)
    private LocalDateTime dateCreation;

    @Column(name = "dateModification", nullable = true)
    private LocalDateTime dateModification;

    @Column(name = "userCreation", nullable = false)
    private int userCreation;

    @Column(name = "userModification", nullable = false)
    private int userModification;

    @Column(name = "dateDelete", nullable = true)
    private LocalDateTime dateDelete;

    @ManyToOne
    @JoinColumn (name = "idUser")
    private User user;

    @ManyToOne
    @JoinColumn (name = "idStatus")
    private Status status;

    public int getIdAlert() {
        return idAlert;
    }

    public void setIdAlert(int idAlert) {
        this.idAlert = idAlert;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDateTime getDateModification() {
        return dateModification;
    }

    public void setDateModification(LocalDateTime dateModification) {
        this.dateModification = dateModification;
    }

    public int getUserCreation() {
        return userCreation;
    }

    public void setUserCreation(int userCreation) {
        this.userCreation = userCreation;
    }

    public int getUserModification() {
        return userModification;
    }

    public void setUserModification(int userModification) {
        this.userModification = userModification;
    }

    public LocalDateTime getDateDelete() {
        return dateDelete;
    }

    public void setDateDelete(LocalDateTime dateDelete) {
        this.dateDelete = dateDelete;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
