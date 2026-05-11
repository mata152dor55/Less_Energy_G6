package com.example.less_energy_g6.DTOs;

import java.math.BigDecimal;

public class AlertConfigDTO {
    private int idAlertConfig;
    private String alertType;
    private BigDecimal valueTreshold;
    private Boolean notifyPush;
    private Boolean notifyEmail;
    private int minuteFrequency;
    private int idStatus;
    private int idUserDevice;

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

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public int getIdUserDevice() {
        return idUserDevice;
    }

    public void setIdUserDevice(int idUserDevice) {
        this.idUserDevice = idUserDevice;
    }
}
