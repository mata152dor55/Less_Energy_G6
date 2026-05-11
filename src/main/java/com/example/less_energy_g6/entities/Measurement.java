package com.example.less_energy_g6.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table (name = "Measurement")
public class Measurement {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idMeasurement;

    @Column (name = "voltage", precision =  6, scale = 2, nullable = false)
    private BigDecimal voltage;

    @Column (name = "current", precision = 6, scale = 2, nullable = false)
    private BigDecimal current;

    @Column (name = "activePower", precision = 8, scale = 2, nullable = false)
    private BigDecimal activePower;

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
    @JoinColumn (name = "idStatus")
    private Status status;

    @ManyToOne
    @JoinColumn (name = "idUserDevice")
    private UserDevice userDevice;


    public int getIdMeasurement() {
        return idMeasurement;
    }

    public void setIdMeasurement(int idMeasurement) {
        this.idMeasurement = idMeasurement;
    }

    public BigDecimal getVoltage() {
        return voltage;
    }

    public void setVoltage(BigDecimal voltage) {
        this.voltage = voltage;
    }

    public BigDecimal getCurrent() {
        return current;
    }

    public void setCurrent(BigDecimal current) {
        this.current = current;
    }

    public BigDecimal getActivePower() {
        return activePower;
    }

    public void setActivePower(BigDecimal activePower) {
        this.activePower = activePower;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UserDevice getUserDevice() {
        return userDevice;
    }

    public void setUserDevice(UserDevice userDevice) {
        this.userDevice = userDevice;
    }
}
