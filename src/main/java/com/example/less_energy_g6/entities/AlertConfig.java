package com.example.less_energy_g6.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "AlertConfig")
public class AlertConfig {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idAlertConfig;

    @Column (name = "alertType", length = 50, nullable = false)
    private String alertType;

    @Column (name = "valueTreshold", precision = 10, scale = 2)
    private BigDecimal valueTreshold;

    @Column (name = "notifyPush", nullable = false)
    private Boolean notifyPush;

    @Column (name = "notifyEmail", nullable = false)
    private Boolean notifyEmail;

    @Column (name = "minuteFrequency", nullable = false)
    private int minuteFrequency;

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

    public int getIdAlertConfig() {
        return idAlertConfig;
    }

    public void setIdAlertConfig(int idAlertConfig) {
        this.idAlertConfig = idAlertConfig;
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public BigDecimal getValueTreshold() {
        return valueTreshold;
    }

    public void setValueTreshold(BigDecimal valueTreshold) {
        this.valueTreshold = valueTreshold;
    }

    public Boolean getNotifyPush() {
        return notifyPush;
    }

    public void setNotifyPush(Boolean notifyPush) {
        this.notifyPush = notifyPush;
    }

    public Boolean getNotifyEmail() {
        return notifyEmail;
    }

    public void setNotifyEmail(Boolean notifyEmail) {
        this.notifyEmail = notifyEmail;
    }

    public int getMinuteFrequency() {
        return minuteFrequency;
    }

    public void setMinuteFrequency(int minuteFrequency) {
        this.minuteFrequency = minuteFrequency;
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
