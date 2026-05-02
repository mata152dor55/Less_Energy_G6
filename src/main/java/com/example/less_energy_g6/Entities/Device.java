package com.example.less_energy_g6.Entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Device")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDevice;

    @Column(name = "nameDevice", length = 150, nullable = false)
    private String nameDevice;

    @Column(name = "State", nullable = false)
    private Character State;

    @Column(name = "brand", length = 100, nullable = false)
    private String brand;

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

    public int getIdDevice() {
        return idDevice;
    }

    public void setIdDevice(int idDevice) {
        this.idDevice = idDevice;
    }

    public String getNameDevice() {
        return nameDevice;
    }

    public void setNameDevice(String nameDevice) {
        this.nameDevice = nameDevice;
    }

    public Character getState() {
        return State;
    }

    public void setState(Character state) {
        State = state;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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
}
