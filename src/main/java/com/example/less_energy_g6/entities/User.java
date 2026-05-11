package com.example.less_energy_g6.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;

    @Column(name = "nameUser", length = 150, nullable = false)
    private String nameUser;

    @Column(name = "passwordHash", length = 225, nullable = false)
    private String passwordHash;

    @Column(name = "email", length = 150, nullable = false)
    private String email;

    @Column(name = "dateCreation", nullable = false)
    private LocalDateTime dateCreation;

    @Column(name = "dateModification")
    private LocalDateTime dateModification;

    @Column(name = "userCreation", nullable = false)
    private int userCreation;

    @Column(name = "userModification", nullable = false)
    private int userModification;

    @Column(name = "dateDelete", nullable = true)
    private LocalDateTime dateDelete;


    @ManyToOne
    @JoinColumn (name = "idStatus")
    private Status status;

    @ManyToOne
    @JoinColumn (name = "idRole")
    private Role role;

    @ManyToOne
    @JoinColumn (name = "idCountry")
    private Country country;

    public User(){

    }

    public User(int idUser, String nameUser, String passwordHash, String email, LocalDateTime dateCreation, LocalDateTime dateModification, int userCreation, int userModification, LocalDateTime dateDelete) {
        this.idUser = idUser;
        this.nameUser = nameUser;
        this.passwordHash = passwordHash;
        this.email = email;
        this.dateCreation = dateCreation;
        this.dateModification = dateModification;
        this.userCreation = userCreation;
        this.userModification = userModification;
        this.dateDelete = dateDelete;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
