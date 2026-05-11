package com.example.less_energy_g6.entities;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "UserDevice")
public class UserDevice {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idUserDevice;

    @Column (name = "deviceAlias", length = 150, nullable = false)
    private String deviceAlias;

    @Column (name = "createdDateTime", nullable = false)
    private LocalDateTime createdDateTime;

    @Column (name = "editDateTime", nullable = true)
    private LocalDateTime editDateTime;

    @Column (name = "editUser", nullable = true)
    private int idEditUser;

    @Column (name = "createdUser", nullable = true)
    private int idCreatedUser;

    @Column (name = "deleteDateTime", nullable = true)
    private LocalDateTime deleteDateTime;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    @ManyToOne
    @JoinColumn(name = "idStatus")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "idDevice")
    private Device device;

    public int getIdUserDevice() {
        return idUserDevice;
    }

    public void setIdUserDevice(int idUserDevice) {
        this.idUserDevice = idUserDevice;
    }

    public String getDeviceAlias() {
        return deviceAlias;
    }

    public void setDeviceAlias(String deviceAlias) {
        this.deviceAlias = deviceAlias;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public LocalDateTime getEditDateTime() {
        return editDateTime;
    }

    public void setEditDateTime(LocalDateTime editDateTime) {
        this.editDateTime = editDateTime;
    }

    public int getIdEditUser() {
        return idEditUser;
    }

    public void setIdEditUser(int idEditUser) {
        this.idEditUser = idEditUser;
    }

    public int getIdCreatedUser() {
        return idCreatedUser;
    }

    public void setIdCreatedUser(int idCreatedUser) {
        this.idCreatedUser = idCreatedUser;
    }

    public LocalDateTime getDeleteDateTime() {
        return deleteDateTime;
    }

    public void setDeleteDateTime(LocalDateTime deleteDateTime) {
        this.deleteDateTime = deleteDateTime;
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

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
}
