package com.example.less_energy_g6.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

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
    private LocalDate dateCreation;

    @Column(name = "dateModification", nullable = false)
    private LocalDate dateModification;

    @Column(name = "userCreation", nullable = false)
    private LocalDate userCreation;

    @Column(name = "userModification", nullable = false)
    private LocalDate userModification;

    @Column(name = "dateDelete", nullable = false)
    private LocalDate dateDelete;

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

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDate getDateModification() {
        return dateModification;
    }

    public void setDateModification(LocalDate dateModification) {
        this.dateModification = dateModification;
    }

    public LocalDate getUserCreation() {
        return userCreation;
    }

    public void setUserCreation(LocalDate userCreation) {
        this.userCreation = userCreation;
    }

    public LocalDate getUserModification() {
        return userModification;
    }

    public void setUserModification(LocalDate userModification) {
        this.userModification = userModification;
    }

    public LocalDate getDateDelete() {
        return dateDelete;
    }

    public void setDateDelete(LocalDate dateDelete) {
        this.dateDelete = dateDelete;
    }
}
